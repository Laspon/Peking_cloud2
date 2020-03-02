define("app/common/tpl/search_list.html", [],
'<!-- 文件夹列表 -->\
{{each data.folderlist as v i}}\
	 <li class="file-item open" data-path="{{v.path | window.pathHashEncode}}" data-type="folder" data-ext="folder">\
		<div class="file-info">\
			<span class="switch"><i class="font-icon icon-file-text-alt"></i></span>\
			<span class="file-icon">{{\'folder\' |core.icon}}</span>\
			<span class="title" title="跳转到 {{v.path | window.htmlEncode}}">{{v.name | searchResultPrase}}</span>\
			<span class="goto" title="进入所在目录"><i class="icon-folder-open-alt"></i></span>\
		</div>\
	</li>\
{{/each}}\
\
<!-- 文件列表 -->\
{{each data.filelist as v i}}\
	{{if v.search_info}}\
	<li class="file-item open" data-path="{{v.path | window.pathHashEncode}}" data-type="file" data-ext="{{v.ext}}">\
		<div class="file-info file-result">\
			<span class="switch"><i class="font-icon icon-caret-right"></i></span>\
			<span class="file-icon">{{v.ext |core.icon}}</span>\
			<span class="title" title="跳转到 {{v.path | window.htmlEncode}}">{{v.name | window.htmlEncode}}</span>\
			<span class="result-num">{{v.search_info.length}}</span>\
			<span class="goto" title="进入所在目录"><i class="icon-folder-open-alt"></i></span>\
		</div>\
		<ul class="result-item">\
			{{each v.search_info as value index}}\
			<li class="result-info">\
				<span class="line" data-line="{{value.line}}">{{value.line}}:</span>\
				<span class="search-info">{{#value.str | searchResultPrase}}</span>\
			</li>\
			{{/each}}\
		</ul>\
	</li>\
	{{else}}\
	<li class="file-item open" data-path="{{v.path | window.pathHashEncode}}" data-type="file-name" data-ext="{{v.ext}}">\
		<div class="file-info">\
			<span class="switch"><i class="font-icon icon-file-text-alt"></i></span>\
			<span class="file-icon">{{v.ext |core.icon}}</span>\
			<span class="title" title="跳转到 {{v.path | window.htmlEncode}}">{{v.name | searchResultPrase}}</span>\
			<span class="goto" title="进入所在目录"><i class="icon-folder-open-alt"></i></span>\
		</div>\
	</li>\
	{{/if}}\
{{/each}}'
);
