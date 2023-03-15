const header = document.querySelector("header");


window.addEventListener("scroll", function() {
    header.classList.toggle("sticky", window.scrollY > 80);
});


let menu = document.querySelector('#menu-icon');
let navlist = document.querySelector('.navlist');

menu.onclick = () => {
    menu.classList.toggle('bx-x');
    navlist.classList.toggle('open')
}

window.onscroll = () => {
    menu.classList.remove('bx-x');
    navlist.classList.remove('open')
}

const scr = ScrollReveal({
    origin: 'top',
    distance: '85px',
    duration: 2500,
    rest: true
});

scr.reveal ('.home-text',{delay: 300});
scr.reveal ('.home-img',{delay: 400});
scr.reveal ('.container',{delay: 400});

scr.reveal ('.about-img',{});
scr.reveal ('.about-txt',{delay: 300});

scr.reveal ('.middle-txt',{});
scr.reveal ('.row-btn,.shop-content',{delay: 300});

scr.reveal ('.review-content, .contact',{delay: 300});


