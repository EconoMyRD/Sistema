document.getElementById('submit').addEventListener('click', getRelatory);

document.getElementById('category').addEventListener('load',getCategories());

function getCategories() {
	var ajax = ajaxInit();
	var url = 'http://localhost:8080/Economy/ServletCategory';
	ajax.open('GET', url, true);
	ajax.send();
	
	ajax.onreadystatechange = function(){
		var json = ajax.responseText;
		if (ajax.readyState==4 && ajax.status==200)
			insertCategories(json);
	};	
}


function insertCategories(json) {
		var categories = JSON.parse(json);
		var html= "";
		for (var i in categories) {
			html+= '<option value = "';
			html+= categories[i].id + '">';
			html+= categories[i].nome;
			html += '</option>';   				    				
		}  		
		document.getElementById('category').innerHTML = html;
}
function getRelatory(event) {
	event.preventDefault();
	var dateS = document.getElementById('dateStart').value;
	var dateE = document.getElementById('dateEnd').value;
	var category = document.getElementById('category').value;

	var dateStart = formatDate(dateS);
	var dateEnd =  formatDate(dateE);
	
	//this method is in the makeGraphic.js file
	getDataForGraphic(dateStart, dateEnd, category);
	
	
};



function formatDate(input) {
	var p = input.split(/\D/g);
	var result = [ p[2], p[1], p[0] ].join("/");

	return result;
};

