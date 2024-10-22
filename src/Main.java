import java.util.*;

import Entity.Imobiliaria;
import Exception.InputCustomException;
import Enum.Type;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Imobiliaria> imobList = new TreeMap<>();

        int opcao = 0;
        do {
            try {

                System.out.printf("MENU %n1 -> Adicionar Imóvel %n2 -> Remover Imóvel %n3 -> Mostrar ordenado pelo codigo %n4 -> Procurar por Código %n5 -> Sair%n");
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("digite o código do imóvel: ");
                        int codigoImovel = sc.nextInt();
                        System.out.printf("%ndigite o tipo: 1 -> Residencial 2 -> Comercial 3 -> Galpão %n");
                        int tipo = sc.nextInt();

                        Type type = switch (tipo) {
                            case 1 -> Type.RESIDENCIAL;
                            case 2 -> Type.COMERCIAL;
                            case 3 -> Type.GALPAO;
                            default -> null;
                        };

                        System.out.print("digite o valor do aluguel base: ");
                        double valorAluguel = sc.nextDouble();
                        Entity.Imobiliaria imb = new Entity.Imobiliaria(codigoImovel,valorAluguel,type);
                        imobList.put(codigoImovel,imb);
                        break;

                    case 2:
                        System.out.print("Digite o código do imóvel a remover: ");
                        int codeRemove = sc.nextInt();
                        if (imobList.containsKey(codeRemove)) {
                            imobList.remove(codeRemove);
                        } else {
                            System.out.println("Número digitado não corresponde a imóvel algum.");
                        }
                        break;

                    case 3:
                        if (!imobList.isEmpty()) {
                            System.out.println("\nCódigo    Valor Aluguel    Tipo");
                            for (Integer listImb : imobList.keySet()){
                                System.out.println(imobList.get(listImb));
                            }
                            System.out.println();
                        }
                    break;
                    case 4:
                        System.out.print("Digite o código do imóvel a ser pesquisado: ");
                        int searchCode = sc.nextInt();
                        if(!imobList.isEmpty()){
                            for (Integer searchUser : imobList.keySet()){
                                if (searchUser.equals(searchCode)){
                                    System.out.printf("Código    Valor aluguel    Tipo%n");
                                    System.out.println(imobList.get(searchUser) + "\n");
                                }
                            }
                        }
                    break;
                }
            }catch (InputCustomException e) {
                System.out.println("Entrada Invalida");
            }

            } while (opcao != 5);


        }

    }
