function pop()
{		
	var leftPosition = (window.screen.width / 2) - (400 / 2);
	var topPosition = (window.screen.height / 2) - (500 / 2);
	var windowFeatures = 'width=520,height=280,history=no,resizable=no,status=no,scrollbars=yes,menubar=no,left=' + leftPosition + ',top=' + topPosition;
	window.open("ratingPopUp", "pop", windowFeatures);
}

