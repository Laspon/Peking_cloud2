define("app/src/setting/page/wall.html", [],
'<div class="section">\
	<div class=\'box\' data-type="wall">\
		{{each data.setting_all.wallall.split(\',\') as value key}}\
		<div class=\'{{if value==data.user.wall}}this{{/if}} list\' data-value=\'{{value}}\'>\
			<div class=\'ico\'><img src=\'{{G.static_path}}images/wall_page/thumb/{{value}}.jpg\'/></div>\
		</div>\
		{{/each}}\
		<div style="clear:both;"></div>\
	</div>\
</div>\
<div class="panel panel-default {{if G.user_config.wall_diy!=\'true\'}}hidden{{/if}}">\
	<div class="panel-heading"><h3 class="panel-title">自定义壁纸：</h3></div>\
	<div class="panel-body">\
		<div class="form_row theme_bg_image">\
			<div class=\'setting_title\'>URL:</div>\
			<div class="setting_content file_select_input">\
				<input type="text" id="wall_url" {{if data.user.wall.length>3}}value="{{data.user.wall}}"{{/if}}/> \
				<button class="path_select btn btn-default btn-right"><i class="font-icon icon-folder-open"></i></button>\
				<img class="randomImage" src="{{G.static_path+\'images/common/desktop/fengche.png\'}}" title="更换壁纸"/>\
			</div>\
		</div>\
	\
		<!-- 提交 -->\
		<div class="form_row">\
			<div class=\'setting_title\'></div>\
			<div class="setting_content">\
				<button onclick="Setting.tools();" class="btn btn-primary">保存</button>\
			</div>\
		</div>\
	</div>\
</div>');
