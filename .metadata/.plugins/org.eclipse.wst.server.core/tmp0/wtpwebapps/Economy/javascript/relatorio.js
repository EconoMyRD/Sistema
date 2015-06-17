var Relatorio = {

    init: function(){
        document.getElementById('submit').addEventListener('click', Relatorio.getRelatory);
        document.getElementById('category').addEventListener('load', GetOptions.getAllCategories());
        
    },
    
   
    getRelatory: function(event) {
        event.preventDefault();
        var dateS = document.getElementById('dateStart').value;
        var dateE = document.getElementById('dateEnd').value;
        var category = document.getElementById('category').value;

        var dateStart = Relatorio.formatDate(dateS);
        var dateEnd =  Relatorio.formatDate(dateE);

        MakeGraphic.getDataForGraphic(dateStart, dateEnd, category);
    },

    
    formatDate: function(input){
        var p = input.split(/\D/g);
        var result = [p[2],p[1],p[0]].join("/");   

        return result;
    },
    
    showOptions: function(json, field){
        var options = JSON.parse(json);
        var html= "";

        for (var i in options) {
            html+= '<option value = "';
            html+= options[i].id + '">';
            html+= options[i].nome;
            html += '</option>';   				    				
        }    		
        field.innerHTML = html;
        
    },
        
	getAllCategories: function(){
	    var ajax = ajaxInit();
	    var url = 'http://localhost:8080/Economy/ServletCategory';
	    ajax.open('GET', url, true);
	    ajax.send();
	
	    ajax.onreadystatechange = function(){
	        if (ajax.readyState==4 && ajax.status==200){
	            var json = ajax.responseText;
	            var field = document.getElementById('category');
	            GetOptions.showOptions(json,field);
	        }
	    };
	    
	}
};

Relatorio.init();
