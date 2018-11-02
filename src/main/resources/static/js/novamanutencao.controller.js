fetch('http://localhost:8080/veiculos').then(response => response.json()).then(data => {
	data.forEach(item => {
		if(item.situacao == true){
			if(item.status == "LIBERADO"){
				$(".veiculos").append(`<tr>
						<td><span>${item.placa}</span></td>
						<td class="align-middle text-right">
							<a href="#" onclick="escolherPlaca('${item.placa}')" class="btn btn-sm btn-secondary">
								<i class="fas fa-check"></i>
								<span class="sr-only">Selecionar</span>
							</a>
						</td>
					</tr>`);
			}
		}
	});
	
});

fetch('http://localhost:8080/funcionarios').then(response => response.json()).then(data => {
	data.forEach(item => {
		if(item.situacao == false){
			if(item.funcao == "Motorista"){
				$(".funcionarios").append(`<tr>
						<td><span>${item.cpf}</span></td>
						<td><span>${item.nome}</span></td>
						<td class="align-middle text-right">
							<a href="#" onclick="escolherFuncionario('${item.cpf}', '${item.nome}')" class="btn btn-sm btn-secondary">
								<i class="fas fa-check"></i>
								<span class="sr-only">Selecionar</span>
							</a>
						</td>
					</tr>`);
			}
		}

	});
});

function escolherPlaca(placa){
	$("#placa").val(placa);
	$("#modalPlaca").modal('hide');
}

function escolherFuncionario(cpf, nome){
	$("#cpf").val(cpf);
	$("#nome").val(nome);
	$("#modalFuncionario").modal('hide');
}