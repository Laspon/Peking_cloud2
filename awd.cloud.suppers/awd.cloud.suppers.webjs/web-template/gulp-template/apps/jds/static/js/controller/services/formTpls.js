/*TMODJS:{"version":"1.0.0"}*/
!function () {

    function template (filename, content) {
        return (
            /string|function/.test(typeof content)
            ? compile : renderFile
        )(filename, content);
    };


    var cache = template.cache = {};
    var String = this.String;

    function toString (value, type) {

        if (typeof value !== 'string') {

            type = typeof value;
            if (type === 'number') {
                value += '';
            } else if (type === 'function') {
                value = toString(value.call(value));
            } else {
                value = '';
            }
        }

        return value;

    };


    var escapeMap = {
        "<": "&#60;",
        ">": "&#62;",
        '"': "&#34;",
        "'": "&#39;",
        "&": "&#38;"
    };


    function escapeFn (s) {
        return escapeMap[s];
    }


    function escapeHTML (content) {
        return toString(content)
        .replace(/&(?![\w#]+;)|[<>"']/g, escapeFn);
    };


    var isArray = Array.isArray || function(obj) {
        return ({}).toString.call(obj) === '[object Array]';
    };


    function each (data, callback) {
        if (isArray(data)) {
            for (var i = 0, len = data.length; i < len; i++) {
                callback.call(data, data[i], i, data);
            }
        } else {
            for (i in data) {
                callback.call(data, data[i], i);
            }
        }
    };


    function resolve (from, to) {
        var DOUBLE_DOT_RE = /(\/)[^/]+\1\.\.\1/;
        var dirname = ('./' + from).replace(/[^/]+$/, "");
        var filename = dirname + to;
        filename = filename.replace(/\/\.\//g, "/");
        while (filename.match(DOUBLE_DOT_RE)) {
            filename = filename.replace(DOUBLE_DOT_RE, "/");
        }
        return filename;
    };


    var utils = template.utils = {

        $helpers: {},

        $include: function (filename, data, from) {
            filename = resolve(from, filename);
            return renderFile(filename, data);
        },

        $string: toString,

        $escape: escapeHTML,

        $each: each
        
    };


    var helpers = template.helpers = utils.$helpers;


    function renderFile (filename, data) {
        var fn = template.get(filename) || showDebugInfo({
            filename: filename,
            name: 'Render Error',
            message: 'Template not found'
        });
        return data ? fn(data) : fn; 
    };


    function compile (filename, fn) {

        if (typeof fn === 'string') {
            var string = fn;
            fn = function () {
                return new String(string);
            };
        }

        var render = cache[filename] = function (data) {
            try {
                return new fn(data, filename) + '';
            } catch (e) {
                return showDebugInfo(e)();
            }
        };

        render.prototype = fn.prototype = utils;
        render.toString = function () {
            return fn + '';
        };

        return render;
    };


    function showDebugInfo (e) {

        var type = "{Template Error}";
        var message = e.stack || '';

        if (message) {
            // 利用报错堆栈信息
            message = message.split('\n').slice(0,2).join('\n');
        } else {
            // 调试版本，直接给出模板语句行
            for (var name in e) {
                message += "<" + name + ">\n" + e[name] + "\n\n";
            }  
        }

        return function () {
            if (typeof console === "object") {
                console.error(type + "\n\n" + message);
            }
            return type;
        };
    };


    template.get = function (filename) {
        return cache[filename.replace(/^\.\//, '')];
    };


    template.helper = function (name, helper) {
        helpers[name] = helper;
    };


    if (typeof define === 'function') {define(function() {return template;});} else if (typeof exports !== 'undefined') {module.exports = template;} else {this.template = template;}
    
    /*v:1*/
template('formTpls/test','');/*v:1*/
template('formTpls/xyrForm',' <div class="right-bottom1 dper-full-w malign-tl"> <div class="right-bottom1-t malign-tl"> <div class="r1 bg-img malign-center-left"></div> <div class="r1-span malign-center-right dper-full-h"><span class="malign-center-text font-24 dper-fw">基本信息</span></div> </div> <div class="right-bottom1-c malign-tl"> <div class="c-span1 malign-tl dper-full-h"> <span class="malign-center-left font-16">姓 &nbsp&nbsp名:</span> <div class="tu bg-img malign-center-left"></div> <input class="input1 malign-center-right" type="text"> </div> <div class="c-span2 malign-tl dper-full-h"> <span class="malign-center-left font-16">性 &nbsp&nbsp别:</span> <div class="tu bg-img malign-center-left"></div> <input class="input2 malign-center-right" type="text"> </div> <select name="" class="c-span3 malign-tr font-16"> <option value="" selected="selected">未核实</option> <option value="">已核实</option> </select> <div class="c-span4 malign-tr font-16"> <span class="malign-center-text">人口库比对</span> </div> <div class="c-span5 malign-tr font-16"> <span class="malign-center-text">在逃对比</span> </div> </div> <div class="right-bottom1-b malign-bl"> <div class="c-span1 malign-tl dper-full-h"> <span class="malign-center-left font-16">证件号:</span> <div class="tu bg-img malign-center-left"></div> <input class="input1 malign-center-right" type="text"> </div> <div class="c-span2 malign-tl dper-full-h"> <span class="malign-center-text font-16">限制会见案件:</span> <div class="tu bg-img malign-center-right"></div> </div> <div class="c-span3 malign-tr dper-full-h font-16"> <input class="input1 malign-center-left" type="radio" name="shi"><span class="span1 malign-center-left">是</span> <input class="input2 malign-center-right" type="radio" name="shi"><span class="malign-center-right">否</span> </div> </div> <div class="xian malign-center-bottom"></div> </div> <div class="right-bottom2 dper-full-w malign-tl"> <div class="right-bottom2-t malign-tl"> <div class="r2 bg-img malign-center-left"></div> <div class="r2-span malign-center-right dper-full-h"><span class="malign-center-text font-24 dper-fw">案件类别</span></div> </div> <div class="right-bottom2-c malign-tl"> <div class="c-span1 malign-tl dper-full-h"> <span class="malign-center-left font-16">案件类别:</span> <div class="tu bg-img malign-center-right"></div> </div> <div class="c-span2 malign-tl dper-full-h font-16"> <input class="input1 malign-center-left" type="checkbox"><span class="span1 malign-center-left">危害国家安全罪</span> <input class="input2 malign-center-right" type="checkbox"><span class="span2 malign-center-right">恐怖活动罪</span> </div> <div class="c-span3 malign-tr dper-full-h font-16"> <span class="malign-center-left">审批单位:</span> <div class="tu bg-img malign-center-left"></div> <input class="input1 malign-center-right" type="text"> </div> <div class="c-span4 malign-tr dper-full-h font-16"> <span class="malign-center-left">审批人:</span> <div class="tu bg-img malign-center-left"></div> <input class="input1 malign-center-right" type="text"> </div> </div> <div class="right-bottom2-b malign-bl"> <div class="c-span1 malign-tl dper-full-h font-16"> <span class="malign-center-left">转入单位:</span> <div class="tu bg-img malign-center-left"></div> <input class="input1 malign-center-right" type="text"> </div> <div class="c-span2 malign-tl dper-full-h font-16"> <span class="malign-center-left">办案人:</span> <div class="tu bg-img malign-center-left"></div> <input class="input1 malign-center-right" type="text"> </div> <div class="c-span3 malign-tr dper-full-h font-16"> <span class="malign-center-left">联系电话:</span> <div class="tu bg-img malign-center-left"></div> <input class="input1 malign-center-right" type="text"> </div> </div> <div class="xian malign-center-bottom"></div> </div> <div class="right-bottom3 dper-full-w malign-bl"> <div class="right-bottom3-t malign-tl"> <div class="r3 bg-img malign-center-left"></div> <div class="r3-span malign-center-right dper-full-h"><span class="malign-center-text font-24 dper-fw">个人信息</span></div> </div> <div class="right-bottom3-t1 malign-tl"> <div class="c-span1 malign-tl dper-full-h font-16"> <span class="malign-center-left">别名或绰号:</span> <div class="tu bg-img malign-center-left"></div> <input class="input1 malign-center-right" type="text"> </div> <div class="c-span2 malign-tl dper-full-h font-16"> <span class="malign-center-left">国 &nbsp&nbsp&nbsp&nbsp&nbsp籍:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">中国</option> <option value="">俄罗斯</option> </select> </div> <div class="c-span3 malign-tl dper-full-h font-16"> <span class="malign-center-left">文化程度:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">初中</option> <option value="">高中</option> <option value="">大学</option> </select> </div> <div class="c-span4 malign-tr dper-full-h font-16"> <span class="malign-center-left">身 &nbsp&nbsp&nbsp份:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">无业人员</option> <option value="">搬砖</option> </select> </div> </div> <div class="right-bottom3-t2 malign-tl"> <div class="c-span1 malign-tl dper-full-h font-16"> <span class="malign-center-left">民&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp族:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">汉族</option> <option value="">土家族</option> </select> </div> <div class="c-span2 malign-tl dper-full-h font-16"> <span class="malign-center-left">档案编号:</span> <div class="tu bg-img malign-center-left"></div> <input class="input1 malign-center-right" type="text"> </div> <div class="c-span3 malign-tl dper-full-h font-16"> <span class="malign-center-left">证件类型:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">身份证</option> <option value="">军官证</option> </select> </div> <div class="c-span4 malign-tr dper-full-h font-16"> <span class="malign-center-left">职 &nbsp&nbsp&nbsp业:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">教师</option> <option value="">公务员</option> </select> </div> </div> <div class="right-bottom3-t3 malign-tl"> <div class="c-span1 malign-tl dper-full-h font-16"> <span class="malign-center-left">出&nbsp生&nbsp日&nbsp期&nbsp:</span> <div class="tu bg-img malign-center-left"></div> <input class="input1 malign-center-right" type="date"> </div> <div class="c-span2 malign-tl dper-full-h font-16"> <span class="malign-center-left">婚姻状况:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">已婚</option> <option value="">未婚</option> </select> </div> <div class="c-span3 malign-tl dper-full-h font-16"> <span class="malign-center-left">户籍所在地:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">重庆</option> <option value="">北京</option> </select> </div> <div class="c-span4 malign-tr dper-full-h font-16"> <span class="malign-center-left">籍 &nbsp&nbsp&nbsp贯:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">重庆</option> <option value="">北京</option> </select> </div> </div> <div class="right-bottom3-t4 malign-tl"> <div class="c-span1 malign-tl dper-full-h font-16"> <span class="malign-center-left">户籍所在地详址:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected"></option> </select> </div> <div class="c-span2 malign-tr dper-full-h font-16"> <span class="malign-center-left">现 住 地 :</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected"></option> </select> </div> </div> <div class="right-bottom3-t5 malign-bl"> <div class="c-span1 malign-tl dper-full-h font-16"> <span class="malign-center-left">政&nbsp治&nbsp面&nbsp貌&nbsp:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">群众</option> <option value="">党员</option> </select> </div> <div class="c-span2 malign-tr dper-full-h font-16"> <span class="malign-center-left">现住地详址:</span> <div class="tu bg-img malign-center-left"></div> <input class="input1 malign-center-right" type="text"> </div> </div> <div class="xian malign-center-bottom"></div> </div> <div class="right-bottom4 dper-full-w malign-bl"> <div class="right-bottom4-t malign-tl"> <div class="r4 bg-img malign-center-left"></div> <div class="r4-span malign-center-right dper-full-h"><span class="malign-center-text font-24 dper-fw">业务信息</span></div> </div> <div class="right-bottom4-c malign-tl"> <div class="c-span1 malign-tl dper-full-h"> <span class="malign-center-left font-16">别名或绰号:</span> <div class="tu bg-img malign-center-right"></div> <input class="input1 malign-center-right" type="text"> </div> <div class="c-span2 malign-tl dper-full-h font-16"> <span class="malign-center-left">国 &nbsp籍:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">中国</option> <option value="">俄罗斯</option> </select> </div> <div class="c-span3 malign-tl dper-full-h font-16"> <span class="malign-center-left">文化程度:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">初中</option> <option value="">高中</option> <option value="">大学</option> </select> </div> <div class="c-span4 malign-tr dper-full-h font-16"> <span class="malign-center-left">身 &nbsp份:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">无业人员</option> <option value="">有业人员</option> </select> </div> <div class="c-span5 malign-tr dper-full-h font-16"> <span class="malign-center-left">民 &nbsp族:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">汉族</option> <option value="">土家族</option> <option value="">苗族</option> </select> </div> </div> <div class="right-bottom4-b malign-bl"> <div class="c-span1 malign-tl dper-full-h"> <span class="malign-center-left font-16">档 案 编 号:</span> <div class="tu bg-img malign-center-right"></div> <input class="input1 malign-center-right" type="text"> </div> <div class="c-span2 malign-tl dper-full-h font-16"> <span class="malign-center-left">证 件 类 型:</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">身份证</option> <option value="">军官证</option> </select> </div> <div class="c-span3 malign-tl dper-full-h font-16"> <span class="malign-center-left">职 &nbsp&nbsp&nbsp&nbsp&nbsp业 :</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected"></option> <option value=""></option> <option value=""></option> </select> </div> <div class="c-span4 malign-tr dper-full-h font-16"> <span class="malign-center-left">出生日期:</span> <div class="tu bg-img malign-center-left"></div> <input class="input1 malign-center-right font-12" type="date"> </div> <div class="c-span5 malign-tr dper-full-h font-16"> <span class="malign-center-left">婚 姻 状 况 :</span> <div class="tu bg-img malign-center-left"></div> <select name="" class="c-span2-s malign-center-right font-16"> <option value="" selected="selected">已婚</option> <option value="">未婚</option> </select> </div> </div> </div> <div class="left-xian malign-center-left"></div> <input type="submit" class="sub malign-bl" value="✓ 保存"> <input type="reset" class="sub1 malign-bl" value="✗ 清空"> ');

}()