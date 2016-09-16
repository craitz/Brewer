$(function() {
	var settings = {
		type : 'json',
		filelimit : 1,
		allow : '*.(jpg|jpeg|png)',
		action : '/brewer/fotos',
		complete : function(resposta) {
			$('input[name=foto]').val(resposta.nome);
			$('input[name=contentType]').val(resposta.contentType);
		}
	};

	UIkit.uploadSelect($('#upload-select'), settings);
	UIkit.uploadDrop($('#upload-drop'), settings);
});