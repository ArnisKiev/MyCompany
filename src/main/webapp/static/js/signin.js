 $(document).ready(() => {
	
	console.log('jQuery -> OK');
	console.log('Validation -> start');
	
	// 1. Створюємо набір змінних для фіксації результатів перевірки окремих полів форми:
	let validate1 = false;	// - результат валідації логіна
	let validate2 = false;	// - результат валідації пароля
	
	// 2. Валідація логіна:
	$('#login').blur(() => {
		console.log('LoginBlur - Done');
		let loginX = $('#login').val();
		console.log('LoginInput - ' + loginX);
		
		let loginRe = /^[a-zA-Z][a-zA-Z0-9_\-]{5,15}$/;
		if (loginRe.test(loginX)) {
			validate1 = false;
			console.log('Login - not valid!');
			$('#login_err').text('Помилка формату введення => логін довжиною від 6 до 16 символів: букв, цифр, _, -');
			// Перевірка наявносты логіну в бд:
			
			$.ajax({
				url: 'auth?page=ajax_signin',
				data: 'login=' + loginX,
				success: (result) => {
					console.log('AJAX -> OK');
					console.log(result);
					if (result === 'YES') {
						validate1 = true;
						console.log('Login - exist!');
						$('#login_err').text('');
					} else {
						validate1 = false;
						console.log('Login - not exist!');
						$('#login_err').text('Логін - не існує! Спробуйте інший!');
					}
				}
			});
			
		} else {
			validate1 = true;
			console.log('Login - not valid!');
			$('#login_err').text('Login - not valid!');
		}
	});
	
	// 3. Валідація 1 пароля:
	$('#pass').blur(() => {
		let passX = $('#pass').val();
		let passRe = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[_\-])[a-zA-Z0-9_\-]{8,}$/;
		console.log(passX);
			
		if (passRe.test(passX)) {
			console.log('pass-OK');
			$('#pass_err').text('');
			validate2 = true;
		} else {
			console.log('pass-FAILED');
			$('#pass_err').text('Помилка формату введення => пароль підвищенної надійсності');
			validate2 = false;
		}
	});
	
	
	// 6. Підсумкова перевірка:
	$('#submit').click(() => {
		console.log('TotalCheck -> start');
		if (validate1 && validate2) {
			console.log('Validate!');
			$('#signinForm').attr('onsubmit', 'return true');
		} else {
			console.log('Not Validate!');
			$('#signinForm').attr('onsubmit', 'return false');
			alert('Форма містить некоректні дані!\nВідправка даних заблокована!');
		}
	});
	
});