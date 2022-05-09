 $(document).ready(() => {
	
	console.log('jQuery -> OK');
	console.log('Validation -> start');
	
	// 1. Створюємо набір змінних для фіксації результатів перевірки окремих полів форми:
	let validate1 = false;	// - результат валідації логіна
	let validate2 = false;	// - результат валідації 1 пароля
	let validate3 = false;	// - результат валідації 2 пароля
	let validate4 = true;	// - результат валідації email
	
	// 2. Валідація логіна:
	$('#login').blur(() => {
		console.log('LoginBlur - Done');
		let loginX = $('#login').val();
		console.log('LoginInput - ' + loginX);
		
		let loginRe = /^[a-zA-Z][a-zA-Z0-9_\-]{5,15}$/;
		if (loginRe.test(loginX)) {
			// Перевірка зайнятості логіну:
			$.ajax({
				url: 'auth?page=ajax_signup',
				data: 'login=' + loginX,
				success: (result) => {
					console.log('AJAX -> OK');
					console.log(result);
					if (result === 'YES') {
						validate1 = true;
						console.log('Login - valid!');
						$('#login_err').text('');
					} else {
						validate1 = false;
						console.log('Login - not free!');
						$('#login_err').text('Логін - зайнятий! Спробуйте інший!');
					}
				}
			});
		} else {
			validate1 = false;
			console.log('Login - not valid!');
			$('#login_err').text('Помилка формату введення => логін довжиною від 6 до 16 символів: букв, цифр, _, -');
		}
	});
	
	// 3. Валідація 1 пароля:
	$('#pass1').blur(() => {
		let pass1X = $('#pass1').val();
		let passRe = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[_\-])[a-zA-Z0-9_\-]{8,}$/;
		console.log(pass1X);
			
		if (passRe.test(pass1X)) {
			console.log('pass1-OK');
			$('#pass1_err').text('');
			validate2 = true;
		} else {
			console.log('pass1-FAILED');
			$('#pass1_err').text('Помилка формату введення => пароль підвищенної надійсності');
			validate2 = false;
		}
	});
	
	// 4. Валідація 2 пароля:
	$('#pass2').blur(() => {
		let pass1X = $('#pass1').val();
		let pass2X = $('#pass2').val();
		console.log(pass1X + '/' + pass2X);
			
		if (pass1X === pass2X) {
			console.log('pass2-OK');
			$('#pass2_err').text('');
			validate3 = true;
		} else {
			console.log('pass2-FAILED');
			$('#pass2_err').text('Введні паролі не співпадають');
			validate3 = false;
		}
	});
	
	// 5. Валідація email:
	// ...
	
	// 6. Підсумкова перевірка:
	$('#submit').click(() => {
		console.log('TotalCheck -> start');
		if (validate1 && validate2 && validate3 && validate4) {
			console.log('Validate!');
			$('#signupForm').attr('onsubmit', 'return true');
		} else {
			console.log('Not Validate!');
			$('#signupForm').attr('onsubmit', 'return false');
			alert('Форма містить некоректні дані!\nВідправка даних заблокована!');
		}
	});
	
});