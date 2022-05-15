$(document).ready(function()
{
	if ($("#alertSuccess").text().trim() == "")
 	{
 	$("#alertSuccess").hide();
 	}
 	$("#alertError").hide();
});

//SAVE
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
 	$("#alertSuccess").hide();
 	$("#alertError").text("");
 	$("#alertError").hide();
 	
 	// Form validation-------------------
 	
	var status = validateItemForm();
	if (status != true)
	{
	$("#alertError").text(status);
	$("#alertError").show();
	return;
	}
	
	// If valid-------------------------
 	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
 	{
 	url : "InquiryAPI",
 	type : type,
 	data : $("#formNotice").serialize(),
 	dataType : "text",
 	complete : function(response, status)
 	{
 		onItemSaveComplete(response.responseText, status);
 	}
 	});
 
});

function onItemSaveComplete(response, status)
{
	if (status == "success")
 	{
 		var resultSet = JSON.parse(response);
 		
 		if (resultSet.status.trim() == "success")
 		{
 			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			
			$("#divItemsGrid").html(resultSet.data);
 		} else if (resultSet.status.trim() == "error")
 		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
 		}
 	} else if (status == "error")
 	{
 		$("#alertError").text("Error while saving.");
 		$("#alertError").show();
 	} else
 	{
 		$("#alertError").text("Unknown error while saving..");
 		$("#alertError").show();
 	} 
 	$("#hidItemIDSave").val("");
 	$("#formNotice")[0].reset();
}

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
	console.log("Update",$("#hidItemIDSave").val());
	$("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());
	 $("#hidItemIDSave").val($(this).data("inquiryID"));
	 
	 $("#name").val($(this).closest("tr").find('td:eq(0)').text());
	 $("#email").val($(this).closest("tr").find('td:eq(1)').text());
	 $("#contactNumber").val($(this).closest("tr").find('td:eq(2)').text());
	 $("#address").val($(this).closest("tr").find('td:eq(3)').text());
	 $("#inquiryType").val($(this).closest("tr").find('td:eq(4)').text());
	 $("#message").val($(this).closest("tr").find('td:eq(5)').text());
});

$(document).on("click", ".btnRemove", function(event)
{
 	$.ajax(
 	{
 		url : "InquiryAPI",
 		type : "DELETE",
 		data : "inquiryID=" + $(this).data("inquiryID"),
 		dataType : "text",
 		complete : function(response, status)
 		{
 			onItemDeleteComplete(response.responseText, status);
 		}
 	});
});

function onItemDeleteComplete(response, status)
{
	if (status == "success")
 	{
 		var resultSet = JSON.parse(response);
 		if (resultSet.status.trim() == "success")
 		{
			 $("#alertSuccess").text("Successfully deleted.");
			 $("#alertSuccess").show();
			 
			 $("#divItemsGrid").html(resultSet.data);
 		} else if (resultSet.status.trim() == "error")
 		{
			 $("#alertError").text(resultSet.data);
			 $("#alertError").show();
 		}
 		} else if (status == "error")
 		{
			 $("#alertError").text("Error while deleting.");
			 $("#alertError").show();
 		} else
		{
			 $("#alertError").text("Unknown error while deleting..");
			 $("#alertError").show();
 		}
}

// CLIENT-MODEL================================================================
function validateItemForm()
{
 
	// NAME
	if ($("#name").val().trim() == "")
	 {
	 return "Insert Name.";
	 } 
	 
	// E-MAIL
	if ($("#email").val().trim() == "")
	 {
	 return "Insert E-mail.";
	 }
	 
	// CONTACT_NUMBER
	let contactNumber = $("#contactNumber").val().trim();
	if (!$.isNumeric(contactNumber)) {
		return "Insert a numerical value for Contact Number.";
	}
	
	// ADDRESS
	if ($("#address").val().trim() == "")
	 {
	 return "Insert Address.";
	 }
	 
	 
	// INQUIRY_TYPE
	if ($("#inquiryType").val().trim() == "")
	 {
	 return "Insert Inquiry Type.";
	 }
	 
	 
	 // MESSAGE
	if ($("#message").val().trim() == "")
	 {
	 return "Insert Message.";
	 }
	 
	 
	
	 
	return true;
}

