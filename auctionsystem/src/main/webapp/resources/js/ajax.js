$(function(){
	 $(document).on('click','.bid_button',function(){
	        var productId = this.id;
	        $( "#dialog-input" ).dialog({
	            resizable: false,
	            height:200,
	            modal: true,
	            buttons: {     	
	            	
	                "Submit": function() {
	                	
	                	var endDate= $('#endDate').val();
	                	console.log(endDate);
	                		           
	                	var today = new Date();
	                	var dd = today.getDate();
	                	var mm = today.getMonth()+1; //January is 0!
	                	var yyyy = today.getFullYear();

	                	if(dd<10) {
	                	    dd='0'+dd
	                	} 

	                	if(mm<10) {
	                	    mm='0'+mm
	                	} 

	                	today = mm+'-'+dd+'-'+yyyy;
//	                	document.write(today);
	                	
	                	
//	                	alert(endDate);
	                	
	                	var price=$( "#bidPrice" ).val();
//	            		alert(price);	            
	            		var minBidPrice= $("#minBidValue").val();
//	            		alert(minBidPrice);
//	            		var biddingUser =$("#bidding_user").val();
	            		
	            		if(price <= minBidPrice){
	            			$( "#dialog-confirm" ).dialog({
	            	            resizable: false,
	            	            height:200,
	            	            modal: true,
	            	            buttons: {
	            	                OK: function() {
	            	                    $( this ).dialog( "close" );
	            	                }
	            	            }
	            	        });
	            			return false;
	            		}
	            		
	            	   	var dataToSend = '{"id":'+productId+',"bidPrice":'+price+'}';
	    
	                    $.ajax({ 
	                    	type: 'POST',
	            			url: '/auctionsystem/addBid',
	            			dataType: "json",           // Accepts
	            	 		data:dataToSend,
	            	 		contentType: 'application/json',   // Sends
	            			success: function(){
	            				
	            				$( "#dialog-ok" ).dialog({
		            	            resizable: false,
		            	            height:200,
		            	            modal: true,
		            	            buttons: {
		            	                OK: function() {
		            	                    $( this ).dialog( "close" );

		            	        			$( '#dialog-input' ).dialog( "close" );
		            	        			
		            	        			
		            	        			
		            	        			var newText = 'Min Bidding price(USD): $'+price;
		            	        			$("#product_"+productId).text(newText);
		            	        			
//		            	        			$("#bid_user").text('Bidded By:'+biddingUser);
		            	                }
		            	            }
		            	        });

	            			},
	                    });

	                },
	                
	                Cancel: function() {
	                    $( this ).dialog( "close" );
	                }
	            }

	        });
	    });
});


