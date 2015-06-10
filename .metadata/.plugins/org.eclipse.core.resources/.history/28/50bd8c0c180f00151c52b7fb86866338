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
			makeGraphic(ajax);
		}
	};
};

function makeGraphic(ajax) {
	//alert(ajax.responseText);
	// google.load('visualization', '1.0', {'packages':['corechart']});
	google.setOnLoadCallback(drawChart(ajax));
};


function drawChart(ajax) {
	var jsonString = ajax.responseText;
	var json = JSON.parse(jsonString);

	var data = new google.visualization.DataTable();
	data.addColumn('string', 'subcategoria');
	data.addColumn('number', 'valor');
	for (var i = 0; i < json.length; i++) {
		data.addRow([ json[i].name, json[i].value ]);
	};
	
	var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
	var options = {
		'width' : 450,
		'height' : 450,
		'title' : 'movimentacoes'
	};

	google.visualization.events.addListener(chart, 'select', function() {
		
		var selectedItem = chart.getSelection()[0];
		var topping = data.getValue(selectedItem.row, 0);
		alert('The user selected ' + topping);
		
	});
	chart.draw(data, options);
};

