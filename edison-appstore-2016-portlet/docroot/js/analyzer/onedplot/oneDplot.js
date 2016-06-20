function legend() {
	this.Title;
	this.SubTitle;
	this.NumField;
	this.LabelX;
	this.LabelY;
	this.Field_str = [];
	this.series = [];
	this.Error;
}

function series() {
	this.Title;
	this.NumPoint;
	this.Point = [];
}

function hc_series() {
	this.name;
	this.data = [];
}

function Point() {
	this.x;
	this.y;
}

function split_file_str(str, title, subtitle) {
	var file_array = new Array();

	file_array = str.split("#");
	var  _legend = new legend();
	_legend.NumField = 0;
	_legend.Title = title;
	_legend.SubTitle = subtitle;

	var _labelx_tmp = new Array();
	var _labely_tmp = new Array();

	for (i=1;i<file_array.length;i++)
	{
		if(file_array[i].indexOf("NumField:") != -1){
			var _temp_label = file_array[++i];
			var Label = new Array();
			Label = _temp_label.split(",");

			var _LabelX = Label[0].substr(8);
			_legend.LabelX = _LabelX.replace(/(^\s*)|(\s*$)/gi, "");
			_labelx_tmp.push(_LabelX.replace(/(^\s*)|(\s*$)/gi, ""));
	
			var _LabelY = Label[1].substr(8);
			_legend.LabelY = _LabelY.replace(/(^\s*)|(\s*$)/gi, "");
			_labely_tmp.push(_LabelY.replace(/(^\s*)|(\s*$)/gi, ""));

			_legend.Field_str.push(file_array[++i]);
			_legend.NumField++;

			continue;
		}	
		if(file_array[i].indexOf("Field") != -1){
			_legend.Field_str.push(file_array[i]);
			_legend.NumField++;
			continue;
		}
	}

	/* check difference label name */
	_legend.Error = false;
/*
	_labelx_tmp.sort();
	var _lastx = _labelx_tmp[0];
	for(var n=1; n<_labelx_tmp.length; n++)
	{
		if(_labelx_tmp[n] != _lastx) _legend.Error = true;
		_lastx = _labelx_tmp[n];
	}
	_labely_tmp.sort();
	var _lasty = _labely_tmp[0];
	for(var n=1; n<_labely_tmp.length; n++)
	{
		if(_labely_tmp[n] != _last) _legend.Error = true;
		_lasty = _labely_tmp[n];
	}
*/
	
	return _legend;
}

function onedstrTojson(oned_str, title, subtitle)
{
        var  legend_tmp = new legend();
        legend_tmp = split_file_str(oned_str, title, subtitle);

        //alert('legend.Title = ' + legend_tmp.Title + '\n');
        //alert('legend.LabelX = ' + legend_tmp.LabelX + '\n');
        //alert('legend.LabelY = ' + legend_tmp.LabelY + '\n');
        //alert('legend.NumField = ' + legend_tmp.NumField + '\n');

        for (i=0;i<legend_tmp.Field_str.length;i++)
        {
//                alert('[' + legend_tmp.Field_str[i] + ']');

		var lines = new Array();
		lines = legend_tmp.Field_str[i].split("\n");

		var _token = new Array();
		_token = lines[0].split(",");
//		alert('Field:' + _token[0].substr(7));
//		alert('NumPoint:' + _token[1].substr(10));

		var series_tmp = new series();

		var _series_Title = _token[0].substr(7);
		series_tmp.Title = _series_Title.replace(/(^\s*)|(\s*$)/gi, "");

		var _series_NumPoint = _token[1].substr(10);
		series_tmp.NumPoint = parseFloat(_series_NumPoint.replace(/(^\s*)|(\s*$)/gi, ""));

		for(j=1; j<lines.length; j++){
			if(lines[j] == "")
			{
				continue;
			}
			else{
				var _line = lines[j].replace(/(^\s*)|(\s*$)/gi, "");

				var _point_token = new Array();
				_point_token = _line.split(" ");

				var _point = new Point();
				_point.x = _point_token[0];

				for(k=1; k< _point_token.length; k++)
				{
					if( _point_token[k] == "" ){
						continue;
					}
					else{
						_point.y = _point_token[k];
					}
				}

				//alert('xpos:' + _point.xpos);
				//alert('ypos:' + _point.ypos);
				series_tmp.Point.push(_point);
			}
		}
		legend_tmp.series.push(series_tmp);
        }

	return legend_tmp;
}


//속도 안나옴.
//function ChangeChartType(chart, series, newType) {
//    newType = newType.toLowerCase();
//    for (var i = 0; i < series.length; i++) {
//        var srs = series[0];
//        try {
//            srs.chart.addSeries({
//                type: newType,
//                stack: srs.stack,
//                yaxis: srs.yaxis,
//                name: srs.name,
//                color: srs.color,
//                data: srs.options.data
//            },
//            false);
//            series[0].remove();
//        } catch (e) {
//        }
//    }
//}

function display_mode_change(ani_mode, renderImage)
{
        if(ani_mode){
                ani_mode = false;
                alert('Still-Cut Mode');
                $("#myImg").remove();
                $("#series_name").remove();
        }
        else{ 
                ani_mode = true;
                alert('Animation Mode');
                chart1.renderer.image(renderImage, 100, 70, 30, 30).attr({id : 'myImg' }).add();
        }

        return ani_mode;
}

function getLegend( oned_raw_data , title, subtitle )
{
        var legend_tmp = new legend();
        legend_tmp = onedstrTojson(oned_raw_data, title, subtitle);

        if( legend_tmp.Error )
        {
                alert("Field Grouping Error...");
        }
  
        //alert("Parsing Completed... Success 2");
        return (legend_tmp);
}

function getOptions( oned_raw_data , title, subtitle, init_options )
{
	var legend2 = new legend();
        legend2 = getLegend(oned_raw_data, title, subtitle);

	var options = init_options;

        options.title.text = legend2.Title;
        options.subtitle.text = legend2.SubTitle;
        options.xAxis.title.text = legend2.LabelX;
        options.yAxis.title.text = legend2.LabelY;

        for (i=0;i<legend2.series.length;i++)
        {
                if(i > 0){
                        var se = new hc_series();
                        se.name = legend2.series[i].Title;
                        for (j=0;j<legend2.series[i].Point.length;j++)
                        {
                                var xx = parseFloat(legend2.series[i].Point[j].x);
                                var yy = parseFloat(legend2.series[i].Point[j].y);

                                if( legend2.series[i].NumPoint <= 1000){
                                        se.data.push( [ xx, yy] );
                                }
                                else if( (legend2.series[i].NumPoint > 1000) && (legend2.series[i].NumPoint <= 5000) ){
                                        if( 0 == (j % 5) )
                                                se.data.push( [xx, yy] );
                                }
                                else if( (legend2.series[i].NumPoint > 5000) && (legend2.series[i].NumPoint <= 10000) ){
                                        if( 0 == (j % 10) )
                                                se.data.push( [xx, yy] );
                                }
                                else if( (legend2.series[i].NumPoint > 10000) && (legend2.series[i].NumPoint <= 50000) ){
                                        if( 0 == (j % 50) )
                                                se.data.push( [xx, yy] );
                                }
                                else if( (legend2.series[i].NumPoint > 50000) && (legend2.series[i].NumPoint <= 100000) ){
                                        if( 0 == (j % 100) )
                                                se.data.push( [xx, yy] );
                                }
                                else{
                                        if( 0 == (j % 1000) )
                                                se.data.push( [xx, yy] );
                                }
                        }
                        options.series.push(se);
                }
                else{
                        options.series[i].name = legend2.series[i].Title;

                        for (j=0;j<legend2.series[i].Point.length;j++)
                        {
                                var xx = parseFloat(legend2.series[i].Point[j].x);
                                var yy = parseFloat(legend2.series[i].Point[j].y);

                                if( legend2.series[i].NumPoint <= 1000){
                                        options.series[i].data.push( [xx, yy] );
                                }
                                else if( (legend2.series[i].NumPoint > 1000) && (legend2.series[i].NumPoint <= 5000) ){
                                        if( 0 == (j % 5) )
                                                options.series[i].data.push( [xx, yy] );
                                }
                                else if( (legend2.series[i].NumPoint > 5000) && (legend2.series[i].NumPoint <= 10000) ){
                                        if( 0 == (j % 10) )
                                                options.series[i].data.push( [xx, yy] );
                                }
                                else if( (legend2.series[i].NumPoint > 10000) && (legend2.series[i].NumPoint <= 50000) ){
                                        if( 0 == (j % 50) )
                                                options.series[i].data.push( [xx, yy] );
                                }
                                else if( (legend2.series[i].NumPoint > 50000) && (legend2.series[i].NumPoint <= 100000) ){
                                        if( 0 == (j % 100) )
                                                options.series[i].data.push( [xx, yy] );
                                }
                                else{
                                        if( 0 == (j % 1000) )
                                                options.series[i].data.push( [xx, yy] );
                                }
                        }
                }
        }
	return options;
}