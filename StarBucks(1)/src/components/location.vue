<template>
    <div id="container"></div>
  </template>
  
  <script>
  import {onMounted,reactive,ref} from 'vue'
  export default {
    setup () {
      
      const initMap = ()=>{
    //定义地图中心点坐标     
        var center = new window.TMap.LatLng(39.984120, 116.307484)
        //定义map变量，调用 TMap.Map() 构造函数创建地图
        
        var map = new window.TMap.Map(document.getElementById('container'), {
            center: center,//设置地图中心点坐标
            zoom: 7.2,   //设置地图缩放级别
        });
  
        //获取缩放控件
        var control = map.getControl(window.TMap.constants.DEFAULT_CONTROL_ID.ZOOM);
        control.setNumVisible(true);
  
  
        //创建并初始化MultiMarker
        var marker = new window.TMap.MultiMarker({
            map: map,  //指定地图容器
            //样式定义
            styles: {
              //创建一个styleId为"myStyle"的样式（styles的子属性名即为styleId）
              //将不同的作物指定为不同的样式
                "myStyle": new window.TMap.MarkerStyle({ 
                    "width": 25,  // 点标记样式宽度（像素）
                    "height": 35, // 点标记样式高度（像素）
                    "url": '../assets/icon/map-marker.png',  //图片路径
                    //"src":'https://mapapi.qq.com/web/lbs/javascriptGL/demo/img/markerDefault.png',
                    //焦点在图片中的像素位置，一般大头针类似形式的图片以针尖位置做为焦点，圆形点以圆心位置为焦点
                    "anchor": { x: 16, y: 32 }  
                }),
                "crop1": new window.TMap.MarkerStyle({
                   "width": 25,  // 点标记样式宽度（像素）
                    "height": 35, // 点标记样式高度（像素）
                    "url": '../assets/icon/Marker.png',  //图片路径
                    "anchor": { x: 16, y: 32 }  
                })
           },
            //点标记数据数组
            geometries: [{
                "id": "1",   //点标记唯一标识，后续如果有删除、修改位置等操作，都需要此id
                "styleId": 'myStyle',  //指定样式id
                "position": new window.TMap.LatLng(39.954104, 116.357503),  //点标记坐标位置
                "properties": {//自定义属性
                    "title": "marker1",
                    "info":"info1"
                }
              }, {//第二个点标记
              "id": "2",
              "styleId": 'crop1',
              "position": new window.TMap.LatLng(39.994104, 116.287503),
              "properties": {
                  "title": "marker2",
                  "info":"info2"
              }
            }]
          });
  
        //创建点聚合对象
        /* var markerCluster = new window.TMap.MarkerCluster({
            id: 'cluster', //图层id
            map: map,       //设置点聚合显示在哪个map对象中（创建map的段落省略）
            enableDefaultStyle: true,   //使用默认样式
            minimumClusterSize: 2,  //最小聚合点数：2个
            geometries: [
              {position: new window.TMap.LatLng(39.982829,116.306934)},
              {position: new window.TMap.LatLng(39.989011,116.323586)},
              {position: new window.TMap.LatLng(39.978751,116.313286)},
              {position: new window.TMap.LatLng(39.980593,116.304359)},
              {position: new window.TMap.LatLng(39.994104, 116.287503)},
              {position: new window.TMap.LatLng(39.954104, 116.357503)},
              //....将您所有要打到图中的坐标点传入进来
              ],
            zoomOnClick: true,  //点击聚合数字放大展开
            gridSize: 60,       //聚合算法的可聚合距离，即距离小于该值的点会聚合至一起，默认为60，以像素为单位
            averageCenter: false, //每个聚和簇的中心是否应该是聚类中所有标记的平均值
            maxZoom: 16 //采用聚合策略的最大缩放级别，若地图缩放级别大于该值，则不进行聚合，标点将全部被展开
        }) */
  
        
        //初始化infoWindow
        var infoWindow = new window.TMap.InfoWindow({
            map: map,
            position: new window.TMap.LatLng(39.984104,116.307503), 
            offset: { x: 0, y: -32 } //设置信息窗相对position偏移像素，为了使其显示在Marker的上方
        });
       
        infoWindow.close();//初始关闭信息窗关闭
        //监听标注点击事件
         marker.on("click", function (evt) {
            //设置infoWindow
            infoWindow.open(); //打开信息窗
            infoWindow.setPosition(evt.geometry.position);//设置信息窗位置
             //将信息与标记点关联起来
            infoWindow.setContent(evt.geometry.properties.title+
            evt.geometry.properties.info);//设置信息窗内容
           
           // console.log(evt)
         })
          
      }
      onMounted(()=>{
        initMap()
      })
      return {
        
      }
    }
  }
  </script>
  
  <style scoped>
  #container {
    /*地图(容器)显示大小*/
    /* width: 1200px;
    height: 400px; */
    width: 100%;
    height: 100%;
  }
  </style>
