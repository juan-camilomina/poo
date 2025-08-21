public class ariables {

    public static void main(String[] args) {

        double d1 = 42.0;
        double d2 = 58.5;
        double d3 = 37.2;
        double t1 = 0.9;
        double t2 = 1.4;
        double t3 = 0.8;
        double l1 = 5.1;
        double l2 = 6.9;
        double l3 = 4.3;
        double precioLitro = 1.35;
        double masacargakg = 1200;
        double largo = 2.0;
        double ancho = 1.2;
        double alto = 1.1;
        double p1 = 2.5;
        double p2 = 3.0;
        double p3 = 2.0;
        double deprecPorKm = 0.08;
        double volcamionM3 = 10.0;
        double fCO2 = 2.68;
        double galPorLitro = 0.264172;
        double vmin = 30;
        double vmax = 90;
        double va = 40;
        double vb = 80;
        double ca = 0.05;
        double cb = 0.09;
        double a = -0.0008;
        double b = 0.08;
        double c = 4.0;
        double w1 = 0.25;
        double w2 = 0.25;
        double w3 = 0.25;
        double w4 = 0.25;

        double v1 = d1/t1;
        double v2 = d2/t2;
        double v3 = d3/t3;

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        double vprom = (d1*v1 + d2*v2 + d3*v3)/ (d1 + d2 + d3);

        System.out.println(vprom);

        double kml1 = d1/l1;
        double kml2 = d2/l2;
        double kml3 = d3/l3;

        System.out.println(kml1);
        System.out.println(kml2);
        System.out.println(kml3);

        double kmltotal = (d1 + d2 + d3)/ (l1 + l2 + l3);

        System.out.println(kmltotal);

        double costoComb = (l1 + l2 + l3) * precioLitro;
        double deprec = (d1 + d2 + d3)* deprecPorKm;
        double peajes = p1 + p2 + p3;

        System.out.println(costoComb);
        System.out.println(deprec);
        System.out.println(peajes);

        double costoDirecto = costoComb + deprec + peajes;
        double costoPorKm = costoDirecto/(d1 + d2 + d3);

        System.out.println(costoDirecto);
        System.out.println(costoPorKm);

        double volumenM3 = largo * ancho * alto;
        double densidad = masacargakg/ volumenM3;
        double ocupacion = volumenM3/volcamionM3;

        System.out.println(volumenM3);
        System.out.println(densidad);
        System.out.println(ocupacion);

        double CO2Total = (l1 + l2 + l3) * fCO2;
        double CO2porKm = CO2Total / (d1 + d2 + d3);

        System.out.println(CO2Total);
        System.out.println(CO2porKm);

        double vmsprom = (vprom * 1000)/3600;
        double galTot = (l1 + l2 + l3) * galPorLitro;

        System.out.println(vmsprom);
        System.out.println(galTot);

        double vnorm = (vprom - vmin) / (vmax - vmin);

        System.out.println(vnorm);

        double vmedia = (v1 + v2 + v3)/ 3;
        double o1 = Math.sqrt((Math.pow(v1 - vmedia, 2) + Math.pow(v2 - vmedia, 2) + Math.pow(v3 - vmedia, 2))/ 3);
        double vpondt = (t1 * v1 + t2*v2 + t3*v3)/ (t1 + t2 + t3);

        System.out.println(vmedia);
        System.out.println(o1);
        System.out.println(vpondt);

        double cvprom = ca + (cb - ca) * (vprom - va)/ (vb - va);
        double costoMant = cvprom * (d1 + d2 + d3);

        System.out.println(cvprom);
        System.out.println(costoMant);

        double kmlv = a*Math.pow(vprom, 2) + b * vprom + c;
        double kmlModelo = kmlv;
        double litrosModelo = (d1 + d2 + d3) / kmlModelo;

        System.out.println(kmlv);
        System.out.println(litrosModelo);

        double score = w1 / costoPorKm + w2 * kmltotal + w3 / CO2porKm + w4 / (1 + o1);

        System.out.println(score);
    }
}