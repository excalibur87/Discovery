function loadData() {
	
	$.ajax({
		type : "GET",
		url : "/danielXaba/services/planet/all",
		dataType : "xml",
		success : function(data) {
		  $(data).find("Planet").each(
			function() {
				var pName = $(this).find('pName').first().text();
				var pNode = $(this).find('pNode').first().text();
				var pId = $(this).find('id').first().text();
				var div_data = "<option value=" + pId + ">" + pName	+ "</option>";
				$(div_data).appendTo('#sel_planet');
			});
		}
	});
}