/* 
 * The MIT License
 *
 * Copyright 2014 Pepe.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
function Util () {}
    
Util.randomRange = function(min, max) {
    
    return min + Math.random() * (max - min);
    
};

Util.getRandomColor = function(){
    
    return tinycolor('hsl(' + Math.round(360*Math.random()) + ',' + '90' + '%,' + '60' + '%)').toHexString();
    
};



Util.getGradientColors = function(num, hue){
    
    var colors = new Array();
    
    if(!hue) hue = Math.round(Math.random()*18)*20+6;
    
    if(hue>360) hue = hue - 360;
    
    for(var h=0 ; h < num; h++){
        
        var i = Math.round(100*h/num);
        
        colors[h] = tinycolor('hsv(' + hue + ',' + i + '%,' + '100' + '%)').toHexString();
    }
    
    return colors;
    
};

Util.getRainbowColors = function(num){
    
    var colors = new Array();
    
    for(var h=0 ; h < num; h++){
        
        var i = Math.round(360*h/num);
        
        colors[h] = tinycolor('hsl(' + i + ',' + '90' + '%,' + '60' + '%)').toHexString();
    }
    
    return colors;
    
};

Util.validateOrGetRandomColor =  function(c) {

    var color;
    
    var colorRegex = /[0-9a-fA-F]{6}/g;
    
    if (c && colorRegex.exec(c)) {
        
        color = '#' + c;
        
    } else {
        
        var letters = '0123456789ABCDEF'.split('');
        
        color = '#';
        
        for (var i = 0; i < 6; i++) {
            
            color += letters[Math.round(Math.random() * 15)];
            
        }
    }
    
    return color;
    
};

Util.checkAll =  function(bx) {
  $(bx).closest('table').find('td input:checkbox').prop('checked', bx.checked);
};

Util.deg = {};
Util.deg.Norte='0';
Util.deg.N='0';
Util.deg.NNE='22';
Util.deg.NE='45';
Util.deg.ENE='67';
Util.deg.Este='90';
Util.deg.E='90';
Util.deg.ESE='112';
Util.deg.SE='135';
Util.deg.SSE='157';
Util.deg.Sur='180';
Util.deg.S='180';
Util.deg.SSO='202';
Util.deg.SO='225';
Util.deg.OSO='247';
Util.deg.Oeste='270';
Util.deg.O='270';
Util.deg.ONO='292';
Util.deg.NO='315';
Util.deg.NNO='337';