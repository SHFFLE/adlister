var submenuHeader = $('nav .list-submenu-header');
var nav = $('nav');
var navlistlink = $('nav .list-link');
var listSubmenu = $('nav .list-submenu');
var hamburger = $('#hamburger');
var hamburgeron = false;
var main = $('main');

submenuHeader.click(function(){
    listSubmenu.css("display", "block");
});
main.on('click', function(){
    listSubmenu.css("display", "none");
});
hamburger.on('click', function(){
    if(hamburgeron == false){
    nav.height("100%");
    navlistlink.css("display", "block");
        submenuHeader.css("display", "block");
        listSubmenu.css("display", "block");
    hamburgeron = true;
    } else if (hamburgeron == true){
        nav.height("1.5em");
        navlistlink.css("display", "none");
        submenuHeader.css("display", "none");
        listSubmenu.css("display", "none");
        hamburgeron = false;
    }
});

if (matchMedia) {
    var mq = window.matchMedia("(min-width: 480px)");
    mq.addListener(WidthChange);
    WidthChange(mq);
}

function WidthChange(mq) {
    if (mq.matches) {
        navlistlink.css("display", "block");
        submenuHeader.css("display", "block");
        listSubmenu.css("display", "none");
    } else {
        nav.height("1.5em");
        navlistlink.css("display", "none");
        submenuHeader.css("display", "none");
        listSubmenu.css("display", "none");
        hamburgeron = false;
    }
}
WidthChange(mq);