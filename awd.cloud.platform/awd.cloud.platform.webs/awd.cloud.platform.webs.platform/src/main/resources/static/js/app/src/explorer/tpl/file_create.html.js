define("app/src/explorer/tpl/file_create.html", [],
"<div class=\"file select {{if type=='file'}}menufile{{else}}menufolder{{/if}} file_icon_edit\" id=\"makefile\">\
{{if list_type=='list'}}<span class=\"children_more\"></span>{{/if}}\
<div class=\"filename\" style=\"padding-top: 0px;\">\
	<span class=\"title\">\
		{{if type=='folder'}}\
		<div class='ico' filetype='folder'>{{\"folder\" | core.icon}}</div>\
			{{else}}\
			<div class='ico' filetype='{{name_ext}}'>{{ext | core.icon}}</div>\
		{{/if}}\
		<div class=\"textarea\">\
			{{if list_type=='icon'}}\
			<textarea class='newfile fix'>{{newname}}</textarea>\
			{{else}}\
			<input class='newfile fix' value='{{newname}}'/>\
			{{/if}}\
		</div>\
	</span>\
</div>\
<div style=\"clear:both;\"></div>\
</div>");