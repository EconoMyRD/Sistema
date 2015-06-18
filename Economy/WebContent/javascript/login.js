
/*Login Menu*/
$("#logar").live('click', function () 
{
    $("#div-logar").hide();
    $("#div-logar").fadeIn('slow');
});


/*Carregar Menu para outras páginas*/
$(document).ready(function()
{  
    $("#header").load("header.html");  
    $("#footer").load("footer.html");
    $("#lancamentos").load("lancamento.html");
}); 


/*Carregar páginas com o clique*/
$(document).ready(function() 
{
    $('.menu-interno').click(function() 
    {
        $("#conteudo").load($(this).attr('href'));
        return false;
    });    
});



