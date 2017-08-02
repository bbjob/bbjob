<#list htmlValue as data>
    <#assign uu = "${data.uu}" />
    <#assign vu = "${data.vu}" />
    <#assign player = "${data.player}" />
    <script type="text/javascript">
        var uu = "${uu?js_string}",
            vu = "${vu?js_string}",
            playerId = "${player?js_string}";
        var player = new CloudVodPlayer();
        player.init({uu:uu,vu:vu,autoReplay:1,dfull:0,auto_play : 1,width:"100%",height:250,x5Type:"h5",fullscreen:1},playerId);
    </script>

    <div>
        <div id="${data.player}" style="overflow: false;left: 0; top: 0; right: 0; width: 100%; height: 250px;"></div>
    </div>
</#list>