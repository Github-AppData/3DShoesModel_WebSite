
    const userCode = "imp62443370";
    IMP.init(userCode);
    function requestPay(){
				var pay_data = [];
		
				var quantity = document.getElementById("quantity").value;
				var shoes_name = document.getElementById("shoes_name").textContent;
		                
		        //class가 btn_payment인 태그를 선택했을 때 작동한다.       
		        var shoesPriceReal = parseInt(shoes_info_final_price);
		        var real_price = shoesPriceReal * quantity;
		                  
		        console.log("shoesPriceReal : ", real_price);
		       	console.log("quantity : ", quantity);
		       	console.log("shoes_id_pay : ", shoes_id_pay);	
		       	
		       	pay_data.push(shoes_id_pay);
		       	pay_data.push(shoes_name);
		       	pay_data.push(quantity);
		       	
		       	pay_data.push(real_price); // 할인까지 한 총 가격.
		       	pay_data.push("Card");
		        
		        // 실제 결제완료시 상품 테이블로 insert 될 수 있도록 서블릿으로 가는 코드.
		        var xhr_pay = new XMLHttpRequest();
		        
		        xhr_pay.onreadystatechange = function()
		        {
					if(xhr_pay.readyState === 4)
					{
						if(xhr_pay.status === 200)
						{
							// 결제완료시 
							alert("결제완료.");
						}
					}
				}
                    //결제시 전달되는 정보
                  IMP.request_pay({
                              pg : 'html5_inicis', 
                              pay_method : 'card',
                              merchant_uid : 'merchant_' + new Date().getTime(),
                              name : shoes_name/*상품명*/,
                              amount : real_price/*상품 가격*/, 
                              buyer_email : 'dlfheks@naver.com'/*구매자 이메일*/,
                              buyer_name : '테스터',
                              buyer_tel : '010-3061-3357'/*구매자 연락처*/,
                              buyer_addr : '서울특별시 강남구 삼성동'/*구매자 주소*/,
                              buyer_postcode : '123-456'/*구매자 우편번호*/
                          }, function(rsp) {
                              var result = '';
                              var msg ='';
                              if ( rsp.success ) {
                                  msg = '결제가 완료되었습니다.\n';
                                  msg += '고유ID : ' + rsp.imp_uid+'\n';
                                  msg += '상점 거래ID : ' + rsp.merchant_uid+'\n';
                                  msg += '결제 금액 : ' + rsp.paid_amount;
	             				  xhr_pay.open("POST", "/RequestPayServlet", true);
     					 		  xhr_pay.send(pay_data);
                                  //result ='0';
                              } else {
                                  msg += '에러내용 : ' + rsp.error_msg;
                                 // result ='1';
                              }
                              alert(msg);
                          });
                           
                      }
    
    function requestPay2() {
		var pay2_data = [];
		
		var quantity = document.getElementById("quantity").value;
		var shoes_name2 = document.getElementById("shoes_name").textContent;
                
        //class가 btn_payment인 태그를 선택했을 때 작동한다.       
        var shoesPriceReal = parseInt(shoes_info_final_price);
        var real_price = shoesPriceReal * quantity;
                  
        console.log("shoesPriceReal : ", real_price);
       	console.log("quantity : ", quantity);
       	console.log("shoes_id_pay : ", shoes_id_pay);	
       	console.log("selected_size2 : ", selected_size);	
       	
       	pay2_data.push(selected_size); 
       	pay2_data.push(shoes_name2);
       	pay2_data.push(shoes_id_pay);
       	pay2_data.push(quantity);
       	pay2_data.push(real_price);
       	pay2_data.push("KaKao");
       	
       	
        
        // 실제 결제완료시 상품 테이블로 insert 될 수 있도록 서블릿으로 가는 코드.
        var xhr_pay2 = new XMLHttpRequest();
        
        xhr_pay2.onreadystatechange = function()
        {
			if(xhr_pay2.readyState === 4)
			{
				if(xhr_pay2.status === 200)
				{
					// 결제완료시 
					alert("결제완료.");
				}
			}
		}

        IMP.request_pay({

            pg: "kakaopay",
            pay_method: "card",
            merchant_uid: 'merchant_' + new Date().getTime(),
            name : '주문명:결제테스트'/*상품명*/,
            name: "테스트",
            amount: real_price,
            buyer_name : '테스터',
            buyer_tel: "010-3061-3357",

        }, function(rsp) {
                      var result = '';
                      var msg ='';
                      if ( rsp.success ) {
                          msg = '결제가 완료되었습니다.\n';
                          msg += '고유ID : ' + rsp.imp_uid+'\n';
                          msg += '상점 거래ID : ' + rsp.merchant_uid+'\n';
                          msg += '결제 금액 : ' + rsp.paid_amount;
     					  xhr_pay2.open("POST", "/RequestPayServlet", true);
     					  xhr_pay2.send(pay2_data);
                      } else {
                          msg += '에러내용 : ' + rsp.error_msg;
                      }
                      alert(msg);
                  });
                 
    }