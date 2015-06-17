var novoLancamento = {
    
    init: function(){
        novoLancamento.setForm();
    },
    
    setForm: function(){
        document.getElementById('category').addEventListener('change',novoLancamento.changeSubcategory);
        document.getElementById('category').addEventListener('load',novoLancamento.getCategories());
        document.getElementById('submit').addEventListener('click', novoLancamento.getValues);
    },

    
    changeSubcategory: function(){
        var category = novoLancamento.getOptionCategory();
        novoLancamento.getSubcategories(category);
    },
    
    
    getOptionCategory: function(){
        var category =document.getElementById('category');
        var selected = String(category.options[category.selectedIndex].value);
        
        return selected;
    },                            



     getSubcategories: function(select){    
        var ajax = ajaxInit();
        if (ajax){
            var url= 'http://localhost:8080/Economy/getSubcategories?select=' + select;
            ajax.open('GET', url, true);
            ajax.send();
        }
        ajax.onreadystatechange = function(){
            if (ajax.readyState==4 && ajax.status==200)
            {
                var json = ajax.responseText;
                var field = document.getElementById('subcategory');
                GetOptions.showOptionsSubcategory(json, field);
            }
            
        };
     },

    
    getValues: function(){
        var description = document.getElementById('description').value;
        var value = document.getElementById('value').value;
        var subcategory  = document.getElementById('subcategory');
        var selectedSub = String(subcategory.options[subcategory.selectedIndex].value);
        var date = String(document.getElementById('date_transaction').value);  
        
        formatedDate = novoLancamento.formatDate(date);
        
        novoLancamento.saveOnDataBase(description,value,selectedSub,formatedDate);

    },

    //format date (dd/mm/yyyy)  for send to backend
    formatDate: function(input){
        var p = input.split(/\D/g);
        var result = [p[2],p[1],p[0]].join("/");   

        return result;
    },

    saveOnDataBase: function(description,value, subcategory,date){
        var ajax= ajaxInit();
        if(ajax){
            var url='http://localhost:8080/Economy/servlet?description='+description + '&value=' + value +  '&subcategory=' +                     subcategory + '&date_transaction=' + date;   

            ajax.open('GET', url, true);
            ajax.send();
        }
    },


    getCategories: function(){
        GetOptions.getAllCategories();
        //novoLancamento.changeSubcategory();
    }


};


novoLancamento.init();





