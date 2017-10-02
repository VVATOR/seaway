function fikkFieldRandom(countRandomPosition) {

}

function clearAll() {
	var checkboxes = document.getElementByName("input");

}

// showNewOffers();
function showNewOffers() {

	var timerId = setInterval(function() {
		const xhr = new XMLHttpRequest();
		xhr.open('POST', 'AjaxController');
		xhr.send();
		var listGame = document.getElementById("list-players");
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				listGame.style.color = "green";
				listGame.innerHTML = "1" + listGame.innerHTML;
			} else {
				listGame.style.color = "red";
			}
		}
	},3000);
}