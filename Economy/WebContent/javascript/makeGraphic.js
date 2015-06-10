function getDataForGraphic(dateStart, dateEnd, category) {
	var ajax = ajaxInit();
	if (ajax) {
		var url = 'http://localhost:8080/Economy/ServletRelatory?dateStart='
				+ dateStart + '&dateEnd=' + dateEnd + '&category=' + category;
		ajax.open('GET', url, true);
		ajax.send();
	}
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4 && ajax.status == 200) {
			// var json = ajax.responseText;
			// alert(json);
			var options = getOptions();
			makeGraphic(ajax, options);
		}
	};
};


function getOptions() {
	var options = {
			'width' : 450,
			'height' : 450,
			'title' : 'movimentacoes'
		};
	return options;
};


function makeGraphic(ajax, options) {
	google.setOnLoadCallback(drawChart(ajax, options));
};


function drawChart(ajax,options) {
	var jsonString = ajax.responseText;
	var json = JSON.parse(jsonString);

	var data = new google.visualization.DataTable();
	data.addColumn('string', 'categoria');
	data.addColumn('number', 'valor');
	for (var i = 0; i < json.length; i++) {
		data.addRow([ json[i].name, json[i].value ]);
	};
	
	var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));

	google.visualization.events.addListener(chart, 'select', function() {
		
		var selectedItem = chart.getSelection()[0];
		var selected = data.getValue(selectedItem.row, 0);
		
		var dateS = document.getElementById('dateStart').value;
		var dateE = document.getElementById('dateEnd').value;
		
//		var dateStart = formatDate(dateS);
//		var dateEnd = formatDate(dateE);
		var ds = new Date(dateS);
		var de = new Date(dateE);
		var dateStart = ds.getTime();
		var dateEnd = de.getTime();
		getDataForDetailedGraphic(dateStart, dateEnd, selected);
		
	});
	chart.draw(data, options);
};


function drawDetailedChart(ajax,options) {
	var jsonString = ajax.responseText;
	var json = JSON.parse(jsonString);

	var data = new google.visualization.DataTable();
	data.addColumn('string', 'date');
	data.addColumn('number', 'valor');
	for (var i = 0; i < json.length; i++) {
		data.addRow([ json[i].date, json[i].value ]);
	};
	
	var chartDetailed = new google.visualization.ColumnChart(document.getElementById('chart_div'));
	chartDetailed.draw(data, options);
};


function getDataForDetailedGraphic(dateS, dateE, subcategory) {
	
	var ajax = ajaxInit();
	if (ajax) {
		var url = 'http://localhost:8080/Economy/ServletDetailedGraphic?dateStart='
				+ dateS + '&dateEnd=' + dateE + '&subcategory=' + subcategory;
		ajax.open('GET', url, true);
		ajax.send();
	}
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4 && ajax.status == 200) {
			var options = getDetailedOptions(subcategory);
			google.setOnLoadCallback(drawChart(ajax, options));
			drawDetailedChart(ajax,options);
		};
	};
};

function getDetailedOptions(subcategory){
	var options = {
			'width' : 600,
			'height' : 500,
			'title' : subcategory
		};
	return options;
};

