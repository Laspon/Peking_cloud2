define("app/common/tpl/theme_diy.html", [],
"@media screen and (max-width:100000px) {\
	body .full_background{\
		position: absolute;top: 0px;left: 0px;bottom: 0px;right: 0px;\
				background-color: #020202;background-size: 100% 100%;\
			}\
		\
			{{if blur_size= (bg_blur==0?0:10) }}{{/if}}\
			body .full_background:before{\
				-webkit-filter: blur({{blur_size}}px);\
				-moz-filter: blur({{blur_size}}px);\
				-ms-filter: blur({{blur_size}}px);\
				filter: blur({{blur_size}}px);\
			}\
			{{if bg_type == 'image'}}\
				body .full_background,\
				body .full_background:before,\
				body #body .menu_left,\
				body #body .app_menu_left,\
				body .aui_buttons,\
				body .aui_state_focus .aui_title,body .aui_title{\
					background-image:url({{bg_image}});\
				}\
			body .aui_state_focus .aui_title,body .aui_title{\
					background-size:100%;\
				}\
			{{else}}\
				body .full_background,\
				body .full_background:before,\
				body #body .menu_left, \
				body #body .app_menu_left,\
				body .aui_buttons,\
				body .aui_state_focus .aui_title,body .aui_title{\
					background:{{end_color}};\
				filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='{{start_color}}', endColorstr='{{end_color}}');\
					background-image: -webkit-linear-gradient({{color_rotate}}deg, {{start_color}}, {{end_color}});\
					background-image: -moz-linear-gradient({{color_rotate}}deg, {{start_color}}, {{end_color}});\
					background-image: -o-linear-gradient({{color_rotate}}deg, {{start_color}}, {{end_color}});\
					background-image: -ms-linear-gradient({{color_rotate}}deg, {{start_color}}, {{end_color}});\
					background-image: linear-gradient({{color_rotate}}deg, {{start_color}}, {{end_color}});\
				}\
			{{/if}}\
		}"
);