class Navbar extends HTMLElement {
    constructor() {
        super();
        const shadow1 = this.attachShadow({ mode: 'open' });
        fetch('/src/main/webapp/componets/navbar.html')
            .then(response => response.text())
            .then(data => {
                shadow1.innerHTML = data;
            });
    }
}

customElements.define('navbar-componet', Navbar);

class Footer extends HTMLElement {
    constructor() {
        super();
        const shadow2 = this.attachShadow({ mode: 'open' });
        fetch('/src/main/webapp/componets/footer.html')
            .then(response => response.text())
            .then(data => {
                shadow2.innerHTML = data;
            });
    }
}

customElements.define('footer-componet', Footer);