def x = 2

switch(x) {
    case 1: assert false; break
    case 2: assert true; break
    default: assert false
}
