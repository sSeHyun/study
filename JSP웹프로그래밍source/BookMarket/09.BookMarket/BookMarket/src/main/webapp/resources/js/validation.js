function CheckAddBook() {

	var bookId = document.getElementById("bookId");
	var name = document.getElementById("name");
	var unitPrice = document.getElementById("unitPrice");
	var unitsInStock = document.getElementById("unitsInStock");
	var description = document.getElementById("description");

	
	
	// ��ǰ�ƾƵ� üũ
	if (!check(/^ISBN[0-9]{4,11}$/, bookId,
			"[��ǰ �ڵ�]\nISBN�� ���ڸ� �����Ͽ� 5~12�ڱ��� �Է��ϼ���\nù ���ڴ� �ݵ�� ISBN�� �����ϼ���"))
		return false;
	// ��ǰ�� üũ
	
	if (name.value.length < 4 || name.value.length > 12) {
		alert("[��ǰ��]\n�ּ� 4�ڿ��� �ִ� 50�ڱ��� �Է��ϼ���");
		name.select();
		name.focus();
		return false;
	}
	// ��ǰ ���� üũ
	if (unitPrice.value.length == 0 || isNaN(unitPrice.value)) {
		alert("[����]\n���ڸ� �Է��ϼ���");
		unitPrice.select();
		unitPrice.focus();
		return false;
	}

	if (unitPrice.value < 0) {
		alert("[����]\n������ �Է��� �� �����ϴ�");
		unitPrice.select();
		unitPrice.focus();
		return false;
	} else if (!check(/^\d+(?:[.]?[\d]?[\d])?$/, unitPrice,
			"[����]\n�Ҽ��� ��° �ڸ������� �Է��ϼ���"))
		//return false;

	// ��� �� üũ
	if (isNaN(unitsInStock.value)) {
		alert("[��� ��]\n���ڸ� �Է��ϼ���");
		unitsInStock.select();
		unitsInStock.focus();
		return false;
	}
	
	if (description.value.length < 80) {
		alert("[�󼼼���]\n�ּ� 100���̻� �Է��ϼ���");
		description.select();
		description.focus();
		return false;
	}
	
	function check(regExp, e, msg) {

		if (regExp.test(e.value)) {
			return true;
		}
		alert(msg);
		e.select();
		e.focus();
		return false;
	}

	 document.newBook.submit()
}
