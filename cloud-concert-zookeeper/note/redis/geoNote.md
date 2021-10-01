geoadd china:city 100.00 100.00 cityName
    添加城市坐标

GEODIST china:city beijing shanghai （km）
    显示北京和上海的距离

GEORADIUS china:city 100.00 60.00 半径（）单位（） ）（withdist显示距离）
    显示100.00,60.00为中心半径（）的所有单位

geohash key value1 value2 
    显示两地哈希经纬

ZRANGE key 0 -1 
    查看地图中全部的元素

zerm key value
    移除指定元素