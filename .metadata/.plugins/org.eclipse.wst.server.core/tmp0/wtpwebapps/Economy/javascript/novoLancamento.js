var doc= this.document;

doc.getElementById('category').addEventListener('change',getOptionsSubcategory);
	

function getOptionsSubcategory(){
    var category =doc.getElementById('category');
    var selected = String(category.options[category.selectedIndex].value);
    
    getSubcategories(selected);
}                            
    


function getSubcategories(select){    
    var ajax = ajaxInit();
    if (ajax){
    	var url= 'http://localhost:8080/Economy/getSubcategories?select=' + select;
    	ajax.open('GET', url, true);
    	ajax.send();
    }
    ajax.onreadystatechange = function(json){
    	//aki vai receber o json do java e coloccar no selecet
    	
    	if (ajax.readyState==4 && ajax.status==200)
        {
    		var json = ajax.responseText;
    		
    		var subcategories = JSON.parse(json);
    		var html= "";
    		for (var i in subcategories) {
    			html+= '<option value = "';
    			html+= subcategories[i].id + '">';
    			html+= subcategories[i].nome;
    			html += '</option>';   				    				
			}    		
    		doc.getElementById('subcategory').innerHTML = html;
        }
    };
    };


// get values from form
doc.getElementById('submit').addEventListener('click', 
        function getValues(){
            var description = doc.getElementById('description').value;
            var value = doc.getElementById('value').value;
            var subcategory  = doc.getElementById('subcategory');
            var selectedSub = String(subcategory.options[subcategory.selectedIndex].value);
            var date = String(doc.getElementById('date_transaction').value);  
           
            // formating date;
            formatDate = formatDate(date);
            
            alert(date + formatDate);
            salvarBancoDados(description,value,selectedSub,formatDate);
           
		}
);

//format date (dd/mm/yyyy)  for send to backend
function  formatDate(input){
	var p = input.split(/\D/g);
	var result = [p[2],p[1],p[0]].join("/");   
    
    return result;
};

function salvarBancoDados(description,value, subcategory,date){
    var ajax= ajaxInit();
    if(ajax){
    	//url do servlet com parametros
        var url='http://localhost:8080/Economy/servlet?description='+description + '&value=' + value +  '&subcategory=' + subcategory + '&date_transaction=' + date;   
        
        ajax.open('GET', url, true);
        ajax.send();
    };
};


document.getElementById("category").addEventListener('load',getCategories());


function getCategories() {
	var ajax = ajaxInit();
	var url = 'http://localhost:8080/Economy/ServletCategory';
	ajax.open('GET', url, true);
	ajax.send();
	
	ajax.onreadystatechange = function(){
		if (ajax.readyState==4 && ajax.status==200){
			var json = ajax.responseText;
			insertCategories(json);
		};	
	};
};


function insertCategories(json) {		
		var categories = JSON.parse(json);
		var html= "";
		for (var i in categories) {
			html+= '<option value = "';
			html+= categories[i].id + '">';
			html+= categories[i].nome;
			html += '</option>';   				    				
		}  		
		doc.getElementById('category').innerHTML = html;
		
		//get the options for subCategories
		getOptionsSubcategory();
		
}








