const mini = document.querySelectorAll('.miniFoto');
const mainFoto = document.getElementById('headPhoto');
let miniImg = null;

        mini.forEach((samllFoto) => {
            samllFoto.addEventListener('click', () => {
                if (miniImg) {
                    miniImg.classList.remove('acctive');
                }

                samllFoto.classList.add('acctive');

                mainFoto.src = samllFoto.src;

                miniImg = samllFoto;
            });
        });