import React from 'react';

const DataTable = ({ data, columns, page, totalPages, onPageChange, onSort, sortConfig }) => {
    return (
        <div className="table-container">
            <table border="1" style={{ width: '100%', textAlign: 'left', borderCollapse: 'collapse' }}>
                <thead>
                    <tr style={{ backgroundColor: '#f2f2f2' }}>
                        {columns.map(col => (
                            <th key={col.key} onClick={() => onSort(col.key)} style={{ cursor: 'pointer', padding: '10px' }}>
                                {col.label} {sortConfig.key === col.key ? (sortConfig.direction === 'asc' ? '▲' : '▼') : '↕'}
                            </th>
                        ))}
                    </tr>
                </thead>
                <tbody>
                    {data.map((row) => (
                        <tr key={row.id}>
                            {columns.map(col => <td key={col.key} style={{ padding: '10px' }}>{row[col.key]}</td>)}
                        </tr>
                    ))}
                </tbody>
            </table>
            <div style={{ marginTop: '10px', display: 'flex', gap: '10px', alignItems: 'center' }}>
                <button disabled={page === 0} onClick={() => onPageChange(page - 1)}>Previous</button>
                <span>Page {page + 1} of {totalPages}</span>
                <button disabled={page >= totalPages - 1} onClick={() => onPageChange(page + 1)}>Next</button>
            </div>
        </div>
    );
};

export default DataTable;