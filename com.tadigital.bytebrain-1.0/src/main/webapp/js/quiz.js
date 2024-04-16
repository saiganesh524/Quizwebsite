document.querySelector('form').addEventListener('submit', function(e) {
	e.preventDefault();
	let radios = document.querySelectorAll('input[type="radio"]');
	let count = 0;
	for (let i = 0; i < radios.length / 4; ++i) {
		let name = ".q-" + i;
		let options = document.querySelectorAll(name);
		let choosed;
		options.forEach(option => {
			if (option.type == 'hidden') {
				console.log("answer is ", option.value);
				if (choosed == option.value) {
					count++;
				}
			}
			if (option.checked) {
				console.log("u have checked ", option.nextSibling.innerText);
				choosed = option.nextSibling.innerText;
			}
		})
	}
	document.getElementById("answers").style.display = 'none';
	document.getElementById("result").style.display = 'block';

	var score = document.getElementById("score");
	score.innerHTML += "Total marks are " + count;
});