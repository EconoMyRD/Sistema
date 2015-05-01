
var link = document.querySelector('link[rel="import"]');
var content = link.import;

var el;
el = content.querySelector('#commonContent');

document.body.appendChild(el.cloneNode(true));