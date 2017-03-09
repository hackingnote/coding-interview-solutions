$(document).ready(function()
{$('#nestable1').nestable({group:1});$('#nestable2').nestable({group:1});var $expand=false;$('#nestable-menu').on('click',function(e)
{if($expand){$expand=false;$('.dd').nestable('expandAll');}else{$expand=true;$('.dd').nestable('collapseAll');}});$('#nestable3').nestable();});