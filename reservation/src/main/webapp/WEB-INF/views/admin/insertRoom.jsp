<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<%@page import="java.util.*"%>
<% 
    request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>

<!-- 방 등록/수정 -->

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-colorpicker/2.3.3/css/bootstrap-colorpicker.min.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-colorpicker/2.3.3/js/bootstrap-colorpicker.min.js"></script>  



<body>
<div class="work-area">	
　　　 <div align="center">
        <h2>部屋登録</h2>
    </div>

	<form id="insertForm" name="insert" action="/admin/insertRoom" method="post" enctype="multipart/form-data" accept-charset="utf-8">
			<table class="table table-bordered">		
			    <tr>
					<td class="text-center"><strong>部屋の名前</strong></td>		
					<td colspan="3"><input type="text" required="required" id="roomTitle" name="roomTitle" class="col-sm-9 col-form-label"></td>		
				</tr>
				<tr>
					<td class="text-center"><strong>最大人数</strong></td>		
					<td colspan="3"><input type="text" required="required" id="max" name="max" class="col-sm-9 col-form-label"></td>		
				</tr>
				<tr>
					<td class="text-center"><strong>大人料金</strong></td>		
					<td colspan="3"><input type="text" required="required" id="adultCost" name="adultCost" class="col-sm-9 col-form-label"></td>		
				</tr>
				<tr>
					<td class="text-center"><strong>子供料金</strong></td>
					<td colspan="3"><input type="text" required="required" id="childCost" name="childCost" class="col-sm-9 col-form-label"></td>		
				</tr>
				<tr>
					<td class="text-center align-middle"><strong>部屋の情報</strong></td>
					<td colspan="3"><textarea required="required" id="summernote" name="explnation" rows="7" class="col-sm-9 col-form-label"></textarea></td>
				</tr>
				
				<tr>
					<td>
						<input type="file" id="image" name="image">
					</td>
				<tr>
				
				<tr>
					<td class="text-center align-middle"><strong>カーラー</strong></td>
					<td colspan="3">					
				    <input class="form-control" type="text" id="colorCd" name="colorCd"/>
				</tr>
				
				</table>
				<div class="d-grid gap-2 col-6 mx-auto">
					<button type="submit" class="btn btn-primary float-right">登録</button>
				</div>		
		</form>
			
<!-- 	<form id="insertForm" role="form" action="/insertRoom" method="post">
		<br style="clear: both">
		<h3 style="margin-bottom: 25px;">Article Form</h3>
		<div class="form-group">
			<input type="text" class="form-control" id="title" name="title"
				placeholder="title" required>
		</div>
		<div class="form-group">
			<textarea class="form-control" id="summernote" name="content"
				placeholder="content" maxlength="140" rows="7"></textarea>
		</div>
		<button type="submit" id="submit" name="submit"
			class="btn btn-primary pull-right">Submit Form</button>
	</form> -->
			
			
<script>
		$(document).ready(function() {
			$("#colorCd").colorpicker({


			});
			
			$("#summernote").summernote({                                        
				height : 300,
				minHeight : null,
				maxHeight : null,
				focus : true,
				callbacks : {                                                   
					onImageUpload : function(files, editor, welEditable) {       
						for (var i = 0; i < files.length; i++) {
							sendFile(files[i], this);
						}
					}
				}
			});
		});

		function sendFile(file, el) {
			var form_data = new FormData();
			form_data.append('file', file);
			$.ajax({                                                             
				data : form_data,
				type : "POST",
				url : '/image',
				cache : false,
				contentType : false,
				enctype : 'multipart/form-data',                                 
				processData : false,
				success : function(url) {                                         
					$(el).summernote('insertImage', url, function($image) {
						$image.css('width', "25%");
					});
				}
			});
		}
</script>


</div>



</body>
