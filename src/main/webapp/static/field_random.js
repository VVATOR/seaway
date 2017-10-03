document.addEventListener("DOMContentLoaded", addListener);

function addListener() {

	var checkbox = document.querySelector("input[type=checkbox].field-position");

	checkbox.addEventListener('change', function() {
		console.log("aaaaaaaasssssssss");
		alert("ay");
		if (this.checked) {
			alert("fire")
		}
	});

	console.log("aaaaaaaaaa");
}

function fire(point) {

	const xhr = new XMLHttpRequest();
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