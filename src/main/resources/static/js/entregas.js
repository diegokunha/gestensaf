$(document).ready(function(){

	$("#btnFiltrar").click(function() {
		
		var url = "http://localhost:8080/entregasFiltro?sdataini=";
		url += $('#dataIni').val();
		url += "&sdatafim=" + $('#dataFim').val();
		url += "&filtro=" +$('#filtro').val();
		
		$('#tabelaEntrega').find("tbody").empty();
		
		if($('#dataIni').val() == "" || $('#dataFim').val() == ""){
			document.getElementById('valida').innerHTML = '*As datas devem ser preenchidas.';
			return;
		};
		
		if( $('#dataFim').val() < $('#dataIni').val()){
			
			document.getElementById('valida').innerHTML = '*A data final não pode ser menor que a data inicial.';			
			return;
		}
		
		else{
		
		 fetch(url).then(response =>
		 response.json()).then(data => { 
			 data.forEach(item => { 
								
					$('#tabelaEntrega').find("tbody").append(
				 ` 
				 <tr>
					<td>
						<input type="checkbox" value="${item.idEntrega}"/>
					</td>
					<td><span>${item.idEntrega}</span></td>
					<td><span>${item.status}</span></td>
					<td><span>${item.veiculo.placa}</span></td>
					<td><span>${item.funcionario.nome}</span></td>
					<td><span>${item.endereco.municipio}</span></td>
					<td><span>${item.dataEntrega}</span></td>
					<td><span>${item.valor}</span></td>
					<td class="align-middle text-right"><a class="btn btn-sm btn-secondary" title="Imprimir" href="/editaEntrega/${item.idEntrega}"> <i class="fas fa-pen" title="Editar"></i> <span class="sr-only">Editar</span>
					</a> <a class="btn btn-sm btn-secondary" title="Finalizar" href="/finalizaEntregaForm/${item.idEntrega}"> <i class="fas fa-check"></i> <span class="sr-only">Finalizar</span>
					</a> <a class="btn btn-sm btn-secondary" title="Excluir" href="/excluiEntrega/${item.idEntrega}"> <i class="far fa-trash-alt"></i> <span class="sr-only">Cancelar</span>
					</a></td>
				</tr>
			   `);
			 });
		 
		 });
	
		 document.getElementById('valida').innerHTML = '';
		
		};	
		
	});

});

