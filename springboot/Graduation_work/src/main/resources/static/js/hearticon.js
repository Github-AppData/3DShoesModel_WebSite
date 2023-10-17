const likeBtn = document.querySelector('button.like-button');

likeBtn.addEventListener('click', function(e){
  if(likeBtn.classList.contains('liked')){
	  likeBtn.classList.remove('liked');
	}else{
		likeBtn.classList.add('liked');
		setTimeout(() => {
		    likeBtn.classList.remove("liked");
		  }, 1000);
	};
});
	