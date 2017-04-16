/***********基于vue的分页插件***************/
function cone_createPage(pages,count,callback){
    if(count<1)return null;
    var html='<ul class="pagination" style="text-align: right;">';
    html+='<li v-bind:class="pageInfo.current==1?\'disabled\':\'waves-effect\'"><a href="#!" v-on:click="last"><i class="iconfont cone-xiangzuo1"></i></a></li>';
    html+='<li v-for="item in pageInfo.nums" v-bind:class="item==pageInfo.current?\'active\':\'waves-effect\'">';
    html+='<a href="#!" v-on:click="currentClick">{{item}}</a></li>';
    html+='</li>';
    html+='<li v-bind:class="pageInfo.current==pageInfo.count?\'disabled\':\'waves-effect\'"><a href="#!" v-on:click="next"><i class="iconfont cone-xiangyou1"></i></a></li>';
    html+='</ul>';
    html+='</ul>';
    function initNums(count,pages){
        var nums=[];
        if(count!=0){
            for(var i=0;i<pages&&i<count;i++){
                nums.push(i+1);
            }
        }
        return nums;
    }
    var page = {
      template: html,
      data: function () {
        return {
            pageInfo:{
                    current:1,
                    count:count,
                    pages:pages,
                    nums:initNums(count,pages)
                }
        }
      },
      methods:{
        last:function(){
            if(this.pageInfo.current<=1)return;
            this.pageInfo.current--;
            this.restNums();
            callback(this.pageInfo.current);
        },
        currentClick:function(event){
            var index=event.target.innerHTML;
            if(this.pageInfo.current==index)return;
            if(index<=0&&index>=this.pageInfo.count)return;
            this.pageInfo.current=index;
            this.restNums(this.pageInfo.current);
            callback(this.pageInfo.current);
        },
        next:function(){
            if(this.pageInfo.current>=this.pageInfo.count)return;
            this.pageInfo.current++;
            this.restNums();
            callback(this.pageInfo.current);
        },
        restNums:function(){
            var current=parseInt(this.pageInfo.current);
            var n=parseInt(this.pageInfo.pages/2);
            var nums=this.pageInfo.nums;
            var pages=this.pageInfo.pages;
            var count=this.pageInfo.count;
            //页数不满或当前页已经在中间
            if(nums.length<pages||nums[n]==current)return;
            var mvs=current-nums[n];
            var flag=mvs>0?true:false;
            mvs=Math.abs(mvs);
            for(var i=0;i<mvs;i++){
                if(!moveNums(flag))break;
            }
            function moveNums(flag){
                if(flag){//右移1位
                    if(nums[pages-1]>=count)return false;
                    var next=nums[pages-1]+1;
                    nums.push(next);
                    nums.shift();
                }else{//左移1位
                    if(nums[0]<2)return false;
                    var last=nums[0]-1;
                    nums.unshift(last);
                    nums.pop();
                }
                return true;
            }
        }
      }
    }
    return page;
}