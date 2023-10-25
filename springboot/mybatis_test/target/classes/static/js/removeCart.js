function removeCartItem(element, itemPrice) {
    // 클릭된 td 를 찾아서 저장
    const tdElement = element.parentElement;

    // td에 상위 인 tr을 찾아서 저장
    const trElement = tdElement.parentElement;

    // tr 부분을 장바구니 페이지에서 삭제 브라우저 내에서만 삭제 라 이후에 db쪽에서도 삭제해줘야함
    trElement.remove();

    // 위에서 브라우저에서 삭제한 이후에 처리해줘야함 
        
    // db에서도 제거가 되면 여기서 총합 액수를 계산하는 함수 호출
    // recalculateTotal();

	/*
    // 상품 가격만큼 총합에서 차감
    const totalElement = document.querySelector('.cart__total li:last-child span');
    const totalText = totalElement.textContent;
    const total = parseFloat(totalText.replace(/[^0-9.-]+/g, '')); // 숫자만 추출
    const newTotal = total - itemPrice;
    
    if (newTotal >= 0) {
        totalElement.textContent = newTotal.toLocaleString() + '(원)';
    } else {
        totalElement.textContent = '0(원)'; // 음수가 되면 0으로 표시
    }*/
}

function updateSubtotal(inputElement) {
    const quantity = parseInt(inputElement.value);
    const row = inputElement.closest('tr');
    const priceElement = row.querySelector('.cart__price');
    const priceText = priceElement.textContent.trim(); // 가격을 텍스트로 가져옵니다.

    // 텍스트에서 숫자 부분만 추출합니다.
    const regex = /(\d+(?:,\d{3})*)/; // 숫자 포맷을 고려한 정규 표현식
    const match = regex.exec(priceText);

    if (match) {
        const price = parseFloat(match[0].replace(/,/g, '')); // 쉼표를 제거하고 가격을 파싱합니다.

        const subtotal = quantity * price;
        const subtotalElement = row.querySelector('.cart__subtotal span');
        subtotalElement.textContent = subtotal.toLocaleString() + '(원)';

        // 총합을 다시 계산하고 업데이트 위해서 함수 호출
        recalculateTotal();
    }
}

function clearCart() { //장바구니 초기화
   const cartTable = document.querySelector('.shopping__cart__table tbody');
    cartTable.innerHTML = ''; // 장바구니 테이블 내용 비우기
    
    // 총 상품 비용 초기화
    const totalElement = document.querySelector('.cart__total li:last-child span');
    totalElement.textContent = '0(원)';
}

function recalculateTotal() {
    // 총합을 다시 계산하고 업데이트하는 로직을 추가
    const subtotalElements = document.querySelectorAll('.cart__subtotal span');
    let total = 0;

    subtotalElements.forEach(subtotalElement => {
        const subtotalText = subtotalElement.textContent;
        const subtotal = parseFloat(subtotalText.replace(/[^0-9.-]+/g, '')); // 숫자만 추출
        total += subtotal;
    });

    // 계산된 총합을 업데이트합니다.
    const totalElement = document.querySelector('.cart__total li:last-child span');
    totalElement.textContent = total.toLocaleString() + '(원)';
}



