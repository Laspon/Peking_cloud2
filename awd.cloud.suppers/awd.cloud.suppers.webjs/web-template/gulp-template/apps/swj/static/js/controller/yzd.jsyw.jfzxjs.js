define(function (require) {
    require('jquery');
    require('easyui');
    require('easyuiZh');
    require('awd/jquery/compSearchBox');
    require('layer');
    var grid=require('awd/easyui/grid');
    var util=require('awd/easyui/util');
    var url=require('models/url');
    var main = {
        'init': function () {
            $.parser.parse();
            //            $('#txtNewPass').parent().hide();
            main.gridBind();
            main.toolBind();
            $('.comp-search-box').compSearchBox(); //高级查询的条件查询
        },
        'gridBind': function () {
            grid.init('test_table', {
                url: url['/kss_jssw/QueryJsswByYwzt'],
                title: '',
                fit: false,
                width: '100%',
                height: window.innerHeight - 140,
                toolbar: '#toolbar',
                firstLoad: false,
                columns: [{
                        field: 'oid',
                        margin:'0',
                        title: '序号',
                        formatter: function (value, rowData, rowIndex) {
                            return '<input type="radio" name="ryRadio" id="ryRadio' + rowIndex + '" value="' + rowData.oid + '" />';
                        }
          },
                    {
                        field: 'jsbh',
                        width: 150,
                        title: '监所编号',
                        sortable: 'true',
                        formatter: function (value, row) {
                            return '<span title=' + (row.jsbh == null ? '' : row.jsbh) + '>' + (row.jsbh == null ? '' : row.jsbh) + '</span>';
                        }
          },
                    {
                        field: 'jsmc',
                        title: '监所名称',
                        width: 150,
                        sortable: 'true',
                        formatter: function (value, row) {
                            return '<span title=' + (row.jsmc == null ? '' : row.jsmc) + '>' + (row.jsmc == null ? '' : row.jsmc) + '</span>';
                        }
          },
                    {
                        field: 'rybh',
                        title: '人员编号',
                        width: 150,
                        sortable: 'true',
                        formatter: function (value, row) {
                            return '<span title=' + (row.rybh == null ? '' : row.rybh) + '>' + (row.rybh == null ? '' : row.rybh) + '</span>';
                        }
          },
                    {
                        field: 'xm',
                        title: '姓名',
                        width: 150,
                        sortable: 'true',
                        formatter: function (value, row) {
                            return '<span title=' + (row.xm == null ? '' : row.xm) + '>' + (row.xm == null ? '' : row.xm) + '</span>';
                        }
          },
                    {
                        field: 'jssj',
                        title: '拒收时间',
                        width: 150,
                        sortable: 'true',
                        formatter: function (value, row) {
                            return '<span title=' + (row.jssj == null ? '' : row.jssj) + '>' + (row.jssj == null ? '' : row.jssj) + '</span>';
                        }
          },
                    {
                        field: 'jsyy',
                        title: '拒收原因',
                        width: 150,
                        sortable: 'true',
                        formatter: function (value, row) {
                            return '<span title=' + (row.jsyy == null ? '' : row.jsyy) + '>' + (row.jsyy == null ? '' : row.jsyy) + '</span>';
                        }
          },
                    {
                        field: 'jsdw',
                        title: '拒收单位',
                        width: 150,
                        sortable: 'true',
                        formatter: function (value, row) {
                            return '<span title=' + (row.jsdw == null ? '' : row.jsdw) + '>' + (row.jsdw == null ? '' : row.jsdw) + '</span>';
                        }
          },
                    {
                        field: 'yszdyj',
                        title: '医生诊断意见',
                        width: 150,
                        sortable: 'true',
                        formatter: function (value, row) {
                            return '<span title=' + (row.yszdyj == null ? '' : row.yszdyj) + '>' + (row.yszdyj == null ? '' : row.yszdyj) + '</span>';
                        }
          },
                     {
                        field: 'zdzm',
                        title: '诊断证明',
                        width: 150,
                        sortable: 'true',
                        formatter: function (value, row) {
                            return '<span title=' + (row.zdzm == null ? '' : row.zdzm) + '>' + (row.zdzm == null ? '' : row.zdzm) + '</span>';
                        }
          },
                     {
                        field: 'ysxm',
                        title: '医生姓名',
                        width: 150,
                        sortable: 'true',
                        formatter: function (value, row) {
                            return '<span title=' + (row.ysxm == null ? '' : row.ysxm) + '>' + (row.ysxm == null ? '' : row.ysxm) + '</span>';
                        }
          },
                     {
                        field: 'blr',
                        title: '办理人',
                        width: 150,
                        sortable: 'true',
                        formatter: function (value, row) {
                            return '<span title=' + (row.blr == null ? '' : row.blr) + '>' + (row.blr == null ? '' : row.blr) + '</span>';
                        }
          },
        ]
            });
        },
        'toolBind': function () {
            $('#newData').on('click', function () {
                layer.open({
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    maxmin: true,
                    content: $('#newData-wrapper'),
                    zIndex: 1000
                });
            });
        }
    };
    $(main.init);
});