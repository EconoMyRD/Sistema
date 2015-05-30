document.getElementById('submit').addEventListener('click', 
		function getRelatory() {
			var dateS = document.getElementById('dateStar').value;
			var dateE = document.getElementById('dateEnd').value;
			var category = document.getElementById('category');
			
			var dateStart = formatDate(dateS);
			var dateEnd = formatDate(dateE);
			
			getDataForGraphic(dateStart, dateEnd, category);
		});

function  formatDate(input){
	var p = input.split(/\D/g);
	var result = [p[2],p[1],p[0]].join("/");   
    
    return result;
};


function getDataForGraphic(dateStart, dateEnd, category){
	var ajax = ajaxInit();
	var url = 'http://localhost:8080/Economy/servletRelatory?dateStart' +
			dateStart + '&dateEnd' + dateEnd + '&category' + category;
	ajax.open('GET', url,true);
	ajax.send();
}