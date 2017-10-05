function addListener() {

	var checkbox = document
			.querySelectorAll("input[type=checkbox].field-position");

	checkbox.forEach(function(element) {

		element.addEventListener('change', function() {
			console.log("aaaaaaaasssssssss");
			// alert(this.value);
			if (this.checked) {
				// alert("fire");
				fire(this);
			}
		});

		// element.checked = false;
		console.log(element);
	});

	console.log("aaaaaaaaaa");
}

function fire1(point) {

	const
	xhr = new XMLHttpRequest();
	xhr.open('POST', 'FireController?point=' + point);
	xhr.send();
	var listGame = document.getElementById("list-players");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			listGame.style.color = "green";
			listGame.innerHTML = "1" + listGame.innerHTML;
		} else {
			listGame.style.color = "red";
		}
	};
}
function fire(point) {

	const
	xhr = new XMLHttpRequest();
	var gameId = document.getElementById("gameId").value;
	console.log(gameId + "---------");
	var current_userId = document.getElementById("current_user").value;
	xhr.open('POST', 'FireController?point=' + point.value + "&gameId="
			+ gameId + "&userId=" + current_userId);
	xhr.send();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			point.innerHTML = "1" + point.innerHTML;
			point.innerHTML = "1" + point.innerHTML;
			console.log(xhr.responseText);
			point.className += " " + xhr.responseText;
			point.disabled = true;
		} else {

		}
	};
}
// function fire(point) {
//
// const xhr = new XMLHttpRequest();
//	
// xhr.open('POST', 'FireController?point=' +
// point.value+"#gameId=${game.id_g}#user=${current_user.id_u}");
// xhr.send();
// xhr.onreadystatechange = function() {
// if (this.readyState == 4 && this.status == 200) {
// point.innerHTML = "1" + point.innerHTML;
// point.innerHTML = "1" + point.innerHTML;
// console.log( xhr.responseText);
// point.className += " " + xhr.responseText;
// point.disabled = true;
// } else {
//
//
// }
// };
// }

function fillFieldRandom(countRandomPosition) {
	clearAll();
	var checkboxes = document
			.querySelectorAll("input[type=checkbox].field-position");
	var currentCheckCount = 0;
	console.log("aaaaaa");
	while (countRandomPosition > currentCheckCount) {
		var i = Math.floor(Math.random(checkboxes.length)
				* (checkboxes.length - 0));
		console.log(i);
		checkboxes[i].checked = true;
		currentCheckCount++;
	}
}

function clearAll() {
	var listGame = document
			.querySelectorAll("input[type=checkbox].field-position");
	listGame.forEach(function(element) {
		element.checked = false;
		console.log(element);
	});
}

function showNewOffers() {

	var timerId = setInterval(function() {
		const
		xhr = new XMLHttpRequest();
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
	}, 3000);
}

function activateCheckboxes() {
	var listGame = document
			.querySelectorAll("input[type=checkbox].field-position");
	listGame.forEach(function(element) {
		element.disabled = false;
		console.log(element);
	});
}
function inactivateCheckboxes() {
	var listGame = document
			.querySelectorAll("input[type=checkbox].field-position");
	listGame.forEach(function(element) {
		element.disabled = true;
		console.log(element);
	});
}