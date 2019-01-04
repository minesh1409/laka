
function loadMore(listing_id) {
	
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/laka/editStatus/" + listing_id,
		datatype : "html",
		success : function(html) {
			console.log(html);
			swal("Method CAlled");
			swal("Check console log");
			$(".portlet-body").load(html);
			location.reload();
			alert("Success");
		}
		
		

	});
}
