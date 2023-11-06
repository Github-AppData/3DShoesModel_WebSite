/*
// 좋아요 버튼 하나만 선택
const likeBtn = document.querySelector('button.like-button');

likeBtn.addEventListener('click', function(e){
  if(likeBtn.classList.contains('liked')){
	  likeBtn.classList.remove('liked');
	}else{
		likeBtn.classList.add('liked');
		
		//타이머 원래는 1초 지나면 다시 색이 돌아오는데 타이머를 없애서 그냥 on off로 만듬
		//setTimeout(() => {
		    //likeBtn.classList.remove("liked");
		  //},1000);
	};
});
*/
// 모든 좋아요 버튼을 선택
const likeButtons = document.querySelectorAll('button.like-button');

likeButtons.forEach((likeBtn) => {
  likeBtn.addEventListener('click', function(e) {
    if (likeBtn.classList.contains('liked')) {
      likeBtn.classList.remove('liked');
    } else {
      likeBtn.classList.add('liked');
    }
  });
});
