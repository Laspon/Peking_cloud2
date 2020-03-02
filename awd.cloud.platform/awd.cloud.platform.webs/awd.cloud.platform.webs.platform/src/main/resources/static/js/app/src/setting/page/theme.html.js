define("app/src/setting/page/theme.html", [],
'<div class="section">\
	<div class=\'box\' data-type="theme">\
		{{each data.setting_all.themeall.split(\',\') as value key}}\
		<div class=\'{{if value==data.user.theme}}this{{/if}} list\' data-value=\'{{value}}\'>\
			<div class=\'theme ico\'><img src=\'{{G.static_path}}images/thumb/theme/{{value}}.png\'/></div>\
			<div class=\'info\'>{{#LNG[\'theme_\'+value]}}</div>\
		</div>\
		{{/each}}\
		<div style="clear:both;"></div>\
	</div>\
</div>\
\
{{if config = G.user_config.theme_diy}}{{/if}}\
<div class="theme_diy_setting panel panel-default {{if G.user_config.theme!=\'diy\'}}hidden{{/if}}">\
	<div class="panel-heading"><h3 class="panel-title">自定义主题设置</h3></div>\
	<div class="panel-body">\
		<div class="form_row theme_bg_type">\
			<div class=\'setting_title\'>背景:</div>\
			<div class="setting_content">\
				<label><input type="radio" class="kui-radio" name="bg_type" value="image" \
					{{if config.bg_type == \'image\'}}checked="checked"{{/if}} />\
					<span>图片</span>\
				</label>\
				<label><input type="radio" class="kui-radio" name="bg_type" value="color" \
					{{if config.bg_type == \'color\'}}checked="checked"{{/if}} />\
					<span>渐变颜色</span>\
				</label>\
			</div>\
		</div>\
	\
		<div class="theme_bg_type_image {{if config.bg_type != \'image\'}}hidden{{/if}}">\
			<div class="form_row theme_bg_blur">\
				<div class=\'setting_title\'>图片模糊处理:</div>\
				<div class="setting_content">\
					<label class="disable-ripple">\
						<input type="checkbox" class="kui-checkbox-ios size-big" name="bg_blur"  {{if config.bg_blur==\'1\'}}checked="checked"{{/if}}/><em></em>\
					</label>\
				</div>\
			</div>\
			<div class="form_row theme_bg_image">\
				<div class=\'setting_title\'>图片地址:</div>\
				<div class="setting_content file_select_input">\
					<input type="text" name="bg_image" value="{{config.bg_image}}"/> \
					<button class="path_select btn btn-default btn-right"><i class="font-icon icon-folder-open"></i></button>\
					<img class="randomImage" src="{{G.static_path+\'images/common/desktop/fengche.png\'}}" title="更换壁纸"/>\
				</div>\
			</div>\
		</div>\
	\
		<div class="theme_bg_type_color {{if config.bg_type != \'color\'}}hidden{{/if}}">\
			<div class="form_row ">\
				<div class=\'setting_title\'>开始颜色:</div>\
				<div class="setting_content">\
					<input type="text" name="start_color" class="color_picker" value="{{config.start_color}}"/>\
				</div>\
			</div>\
			<div class="form_row ">\
				<div class=\'setting_title\'>结束颜色:</div>\
				<div class="setting_content">\
					<input type="text" name="end_color" class="color_picker" value="{{config.end_color}}"/>\
				</div>\
			</div>\
			<div class="form_row ">\
				<div class=\'setting_title\'>渐变角度:</div>\
				<div class="setting_content">\
					<input type="text" name="color_rotate" id = "colorRotate"\
					data-slider-id=\'colorRotateSlider\' \
					data-slider-min="0"\
					data-slider-max="360"\
					data-slider-step="1"\
					data-slider-value="{{config.color_rotate}}"/>\
				</div>\
			</div>\
	\
			<div class="color_default">\
				<div class="color_list" data-color=\'{"start_color":"#93ad34","end_color":"#198a62","color_rotate":"310"}\'></div>\
				<div class="color_list" data-color=\'{"start_color":"#5648c1","end_color":"#6fe3e7","color_rotate":"160"}\'></div>\
				<div class="color_list" data-color=\'{"start_color":"#7b4397","end_color":"#2b85a6","color_rotate":"300"}\'></div>\
				<div class="color_list" data-color=\'{"start_color":"#860073","end_color":"#4f1670","color_rotate":"300"}\'></div>\
				<div class="color_list" data-color=\'{"start_color":"#248556","end_color":"#16226e","color_rotate":"165"}\'></div>\
				<div class="color_list" data-color=\'{"start_color":"#d16645","end_color":"#13052e","color_rotate":"195"}\'></div>\
				<div class="color_list" data-color=\'{"start_color":"#d23c39","end_color":"#dca74a","color_rotate":"320"}\'></div>\
				<div class="color_list" data-color=\'{"start_color":"#7f7280","end_color":"#000000","color_rotate":"160"}\'></div>\
				<div class="color_list" data-color=\'{"start_color":"#77cfa0","end_color":"#0c2b50","color_rotate":"330"}\'></div>\
				<div class="color_list" data-color=\'{"start_color":"#29c0db","end_color":"#1178c2","color_rotate":"300"}\'></div>\
			</div>\
		</div>\
	\
		<!-- 提交 -->\
		<div class="form_row">\
			<div class=\'setting_title\'></div>\
			<div class="setting_content">\
				<button class="theme_diy_save btn btn-primary">保存</button>\
			</div>\
		</div>\
	\
	</div>\
</div>');
