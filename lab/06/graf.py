
import matplotlib.pyplot as plt

sizes = [100, 1000, 10000]


quick_first_pivot = [95508, 1018576, 2956911]
quick_last_pivot = [83296, 1075959, 2717018]
quick_random_pivot = [416004, 1566801, 3563860]
quick_median_of_three = [82792, 1088974, 2879632]


plt.figure(figsize=(10, 6))


plt.plot(sizes, quick_first_pivot, label='Pivô Primeiro Elemento', marker='o')
plt.plot(sizes, quick_last_pivot, label='Pivô Último Elemento', marker='s')
plt.plot(sizes, quick_random_pivot, label='Pivô Aleatório', marker='^')
plt.plot(sizes, quick_median_of_three, label='Pivô Mediana de Três', marker='d')


plt.title('Tempo de Execução do QuickSort para Arrays Aleatórios', fontsize=14)
plt.xlabel('Tamanho do Array', fontsize=12)
plt.ylabel('Tempo Médio de Execução (nanosegundos)', fontsize=12)


plt.legend()

plt.yscale('log')

plt.grid(True)
plt.show()
