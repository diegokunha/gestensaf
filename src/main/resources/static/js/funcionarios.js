$(document).ready(function(){

	$("#btnFiltrar").click(function() {
		
		var url = "http://localhost:8080/funcionarioFiltro?cpf=";
		url += $('#valorFiltro').val();
		url += "&nome=" + $('#valorFiltro').val();
	
		$('#tabelaFuncionario').find("tbody").empty();
		
		fetch(url).then(response =>
		 response.json()).then(data => { 
			 data.forEach(item => { 
								
					$('#tabelaFuncionario').find("tbody").append(
				 ` 
				 <tr>
					<td><span>${item.cpf}</span></td>
					<td><span>${item.nome}</span></td>
					<td><span>${item.dataNasc}</span></td>
					<td><span>${item.funcao}</span></td>
					<td><span>${item.celular}</span></td>
					
					<td class="align-middle text-right">
						<a href="/editarFuncionario/${item.cpf}(cpf = ${item.cpf})}" class="btn btn-sm btn-secondary" title="Editar">
							<i class="fas fa-pen" ></i>
							<span class="sr-only">Editar</span>
						</a>
					</td>
				</tr>
			   `);
			 });
		 
		 });
		
	});
});
		