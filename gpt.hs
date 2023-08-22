-- Codigo que no hace lo que quiero
-- Esto es lo que tenemos: 
-- punto1 = newP 1 1
-- punto2 = newP 2 2
-- punto3 = newP 3 3

-- madrid = newC "Madrid" punto1
-- berlin = newC "Berlin" punto2
-- bsas = newC "Buenos Aires" punto3

-- calidad1 = newQ "calidad1" 1 1.0
-- calidad2 = newQ "calidad2" 2 2.0
-- calidad3 = newQ "calidad3" 3 3.0

-- linkMB = newL madrid berlin calidad1
-- linkBM = newL berlin madrid calidad1
-- linkBBSAS = newL berlin bsas calidad2
-- linkBSASB = newL bsas berlin calidad2
-- linkMBSAS = newL madrid bsas calidad3
-- linkBSASM = newL bsas madrid calidad3

-- tunelMBSAS = newT [linkMB, linkBBSAS]

-- region1 = newR
-- city1 = foundR region1 madrid
-- city2 = foundR region1 berlin
-- city3 = foundR region1 bsas

-- primerlink = linkR region1 madrid berlin calidad1
-- segundolink = linkR region1 berlin bsas calidad2

-- camino1 = linksForR region1 madrid bsas

Lo que pasa es que camino1 no estaria lo que necesito, es decir no me esta devolviendo la lista
con [primerlink, segundolink].
Para que entiendas mejor, si a linksforR le hubiera pasado region1 madrid berlin, me tendria que devolver
solo primerlink.

Estas es la funcion:
linksForR :: Region -> City -> City -> [Link] -- indica los enlaces que hay que seguir para ir de una ciudad a otra
linksForR (Reg cities links tunels) city1 city2 = foldr findLinks [] links
      where 
         findLinks link acc 
                           | connectsL city2 link = link : acc
                           | otherwise = acc

Esta funcion usa:

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL thisCity (Lin cityA cityB quality) | thisCity == cityA || thisCity == cityB = True
                                             | otherwise = False

Dame una respuesta corta y como arreglarlo. Seguro pienses que no estoy teniendo en cuenta city1, pero no es necesario, 
si te das cuenta, yo debo iterar sobre la lista de links evaluando connectsL con city2, 
ya que cuando eso me devuelva true, yo se que ahi debo terminar y quedarme con todo el otro pedazo anterior, 
incluyendo este ultimo link que dio True. Tene en cuenta que la lista esta ordenada, es decir,
seria algo asi la lista. [linkAB, linkBC, LinkCD, linkDE, linkEF]