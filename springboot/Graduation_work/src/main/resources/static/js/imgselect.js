function updateImage() {
	var imageInput = document.getElementById("image-input");
	var selectedImage = document.getElementById("selected-image");

	if (imageInput.files && imageInput.files[0]) {
		var reader = new FileReader();
		 	reader.onload = function(e) {
		      selectedImage.src = e.target.result;
		    };
		    reader.readAsDataURL(imageInput.files[0]);
		}
}

function resetImage() {
	var selectedImage = document.getElementById("selected-image");
		selectedImage.src = "img/banner/banner-2.jpg";
}